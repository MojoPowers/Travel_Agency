package com.step.tourist_agency.exception.parent;

public class CommonException extends RuntimeException {

    public CommonException() {
        this("Common exception");
    }

    public CommonException(String message) {
        super(message);
    }

}