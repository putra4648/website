package com.putra.portfolio.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.putra.portfolio.dto.ProjectDto;
import com.putra.portfolio.model.ProjectModel;
import com.putra.portfolio.repository.ProjectRepository;
import com.putra.portfolio.request.ProjectRequest;
import com.putra.portfolio.response.AppResponse;
import com.putra.portfolio.service.ProjectService;

@Service("portfolioService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    @Autowired
    private ProjectRepository repository;

    private boolean isError = false;
    private String message = null;

    @Override
    public ResponseEntity<AppResponse<ProjectDto>> getList() {
        AppResponse<ProjectDto> body = new AppResponse<>();
        body.setError(false);
        body.setMessage("success");
        body.setResults(repository.findAll().stream().map(d -> {
            ProjectDto dto = new ProjectDto();
            dto.setId(d.getId());
            dto.setName(d.getName());
            dto.setDescription(d.getDescription());
            dto.setLink(d.getLink());
            dto.setTags(d.getTags());
            dto.setImages(d.getImageIds().stream().map(f -> {
                try {
                    MessageFormat format = new MessageFormat("data:{0};base64,{1}");
                    GridFsResource resource = new GridFsResource(
                            template.findOne(new Query(Criteria.where("_id").is(f))));
                    GridFsResource contents = operations.getResource(resource.getFilename());
                    return format.format(
                            new String[] { Files.probeContentType(Paths.get(contents.getFilename())),
                                    Base64.getMimeEncoder().encodeToString(contents.getContentAsByteArray()) });
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }).toList());
            return dto;
        }).toList());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<AppResponse<String>> upload(ProjectRequest request) {
        AppResponse<String> response = new AppResponse<>();

        if (!isError) {
            List<ProjectModel> results = repository.findByName(request.getName());

            if (results.isEmpty()) {
                response.setError(false);
                response.setMessage("Success add new portfolio");

                ProjectModel model = new ProjectModel();
                model.setName(request.getName());
                model.setDescription(request.getDescription());
                model.setTags(request.getTags());
                model.setLink(request.getLink());
                model.setImageIds(request.getImages().stream().map(i -> {
                    try {
                        Optional<String> ext = Optional.ofNullable(i.getOriginalFilename())
                                .filter(f -> f.contains("."))
                                .map(f -> f.substring(i.getOriginalFilename().lastIndexOf(".") + 1));
                        if (ext.isEmpty()) {
                            throw new IOException("File type is not supported!");
                        } else {
                            String fileExt = FilenameUtils.getExtension(i.getOriginalFilename());
                            boolean isExtImagesValid = fileExt.equalsIgnoreCase("png")
                                    || fileExt.equalsIgnoreCase("jpg");
                            if (!isExtImagesValid) {
                                throw new IOException("File must be image!");
                            }
                        }

                        DBObject metadata = new BasicDBObject();
                        metadata.put("filesize", i.getBytes());
                        metadata.put("filename", i.getOriginalFilename());

                        ObjectId storeId = template.store(i.getInputStream(), i.getOriginalFilename(),
                                i.getContentType(), metadata);
                        return storeId.toString();
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
