package com.putra.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.putra.portfolio.interceptor.AppHandleInterceptor;
import com.putra.portfolio.service.LogService;

@Configuration
@EnableWebMvc
public class AppMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LogService logService;

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(new AppHandleInterceptor(logService));
    }
}
