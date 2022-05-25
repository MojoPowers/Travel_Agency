package com.step.tourist_agency.exception;

import com.step.tourist_agency.exception.parent.CommonException;

public class DateTimeMapperException extends CommonException {

    public DateTimeMapperException() {
        this("Incorrect datetime source string");
    }

    public DateTimeMapperException(String message) {
        super(message);
    }
}
