package com.putra.portfolio.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.putra.portfolio.dto.LogDto;
import com.putra.portfolio.model.LogModel;
import com.putra.portfolio.repository.LogRepository;
import com.putra.portfolio.service.LogService;

import lombok.extern.slf4j.Slf4j;

@Service("logService")
@Slf4j
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void createLog(LogDto dto) {
        TypeMap<LogDto, LogModel> typeMap = mapper.typeMap(LogDto.class, LogModel.class);
        typeMap.addMapping(LogDto::getMessage, LogModel::setMessage);
        typeMap.addMapping(LogDto::getHttpMethod, LogModel::setHttpMethod);
        typeMap.addMapping(LogDto::getType, LogModel::setType);

        LogModel model = typeMap.map(dto);

        if (model != null) {
            repository.save(model);
        } else {
            log.error("Failed to create log caused by LogModel is null");
        }
    }

}
