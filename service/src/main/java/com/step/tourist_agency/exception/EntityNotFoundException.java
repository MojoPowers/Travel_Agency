package com.step.tourist_agency.exception;

import com.step.tourist_agency.exception.parent.CommonException;

public class EntityNotFoundException extends CommonException {

    public EntityNotFoundException() {
        this("Entity not found exception");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
