package com.putra.portfolio.interceptor;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.putra.portfolio.dto.LogDto;
import com.putra.portfolio.enums.LogEnums;
import com.putra.portfolio.service.LogService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AppHandleInterceptor implements HandlerInterceptor {

    private LogService logService;

    public AppHandleInterceptor(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @Nullable Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

        LogDto dto = new LogDto();
        dto.setHttpMethod(request.getMethod());
        dto.setType(LogEnums.LOG.getType());
        dto.setMessage(String.valueOf(response.getStatus()));
        logService.createLog(dto);
    }

}
