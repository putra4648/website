package com.putra.portfolio.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.putra.portfolio.dto.PortfolioDto;
import com.putra.portfolio.model.PortfolioModel;
import com.putra.portfolio.repository.PortfolioRepository;
import com.putra.portfolio.request.PortfolioRequest;
import com.putra.portfolio.response.AppResponse;
import com.putra.portfolio.service.PortfolioService;

@Service("portfolioService")
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    @Autowired
    private PortfolioRepository repository;

    private boolean isError = false;
    private String message = null;

    @Override
    public ResponseEntity<AppResponse<PortfolioDto>> getList() {
        AppResponse<PortfolioDto> body = new AppResponse<>();
        body.setError(false);
        body.setMessage("success");
        body.setResults(repository.findAll().stream().map(d -> {
            PortfolioDto dto = new PortfolioDto();
            dto.setId(d.getId());
            dto.setName(d.getName());
            dto.setDescription(d.getDescription());
            dto.setImages(d.getImages());
            return dto;
        }).toList());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<AppResponse<String>> upload(PortfolioRequest request) {
        AppResponse<String> response = new AppResponse<>();

        if (!isError) {
            List<PortfolioModel> results = repository.findByName(request.getName());

            if (results.isEmpty()) {
                response.setError(false);
                response.setMessage("Success add new portfolio");

                PortfolioModel model = new PortfolioModel();
                model.setName(request.getName());
                model.setDescription(request.getDescription());
                model.setImages(request.getImages().stream().map(i -> {

                    try {
                        Optional<String> ext = Optional.ofNullable(i.getOriginalFilename())
                                .filter(f -> f.contains("."))
                                .map(f -> f.substring(i.getOriginalFilename().lastIndexOf(".") + 1));
                        if (ext.isEmpty()) {
                            throw new IOException("File type is not supported!");
                        } else {
                            String fileExt = FilenameUtils.getExtension(i.getOriginalFilename());
                            System.out.println(fileExt);
                            boolean isExtImagesValid = fileExt.equalsIgnoreCase("png")
                                    || fileExt.equalsIgnoreCase("jpg");
                            if (!isExtImagesValid) {
                                throw new IOException("File must be image!");
                            }
                        }

                        DBObject metadata = new BasicDBObject();
                        metadata.put("filesize", i.getBytes());
                        metadata.put("filename", i.getOriginalFilename());

                        ObjectId storeId = template.store(i.getInputStream(), i.getOriginalFilename(), metadata);
                        return storeId.toByteArray();
                    } catch (IOException e) {
                        isError = true;
                        message = e.getLocalizedMessage();
                        return null;
                    }

                }).toList());
                repository.save(model);
            } else {
                response.setError(true);
                response.setMessage("Portofolio already exist");
            }
            return ResponseEntity.ok().body(response);
        } else {
            response.setError(isError);
            response.setMessage(message);
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
