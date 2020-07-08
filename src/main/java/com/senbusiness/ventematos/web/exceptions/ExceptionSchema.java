package com.senbusiness.ventematos.web.exceptions;

import lombok.Data;

@Data
public class ExceptionSchema {

    private String message;

    protected ExceptionSchema() {}

    public ExceptionSchema(String message) {
        this.message = message;
    }
}
