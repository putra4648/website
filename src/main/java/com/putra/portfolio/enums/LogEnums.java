package com.putra.portfolio.enums;

import lombok.Getter;

@Getter
public enum LogEnums {
    LOG("log"), ERROR("error");

    private LogEnums(String type) {
        this.type = type;
    }

    private final String type;

}
