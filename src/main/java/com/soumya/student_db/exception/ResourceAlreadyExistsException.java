package com.soumya.student_db.exception;

import java.lang.RuntimeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException {
    
    private String resource;

    private String field;

    private Integer value;

    public ResourceAlreadyExistsException(String resource, String field, Integer value){
        super(String.format("%s Already Exists With %s: %d", resource,field,value));
        this.resource = resource;
        this.field = field;
        this.value = value;
    }
}
