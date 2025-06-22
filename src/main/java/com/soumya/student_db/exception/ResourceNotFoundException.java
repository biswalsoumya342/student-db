package com.soumya.student_db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    private String resource;

    private String field;

    private String fieldValue;

    public ResourceNotFoundException(String resource,String field,String fieldValue){
        super(String.format("%s Not Found With %s: %s",resource,field,fieldValue));
        this.resource = resource;
        this.field = field;
        this.fieldValue = fieldValue;
    }
}
