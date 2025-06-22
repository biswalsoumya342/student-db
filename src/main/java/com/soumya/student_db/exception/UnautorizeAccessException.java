package com.soumya.student_db.exception;

import java.lang.RuntimeException;

public class UnautorizeAccessException extends RuntimeException {

    private Integer fieldOne;

    private String fieldTwo;

    public UnautorizeAccessException(Integer fieldOne,String fieldTwo){
        super(String.format("Invalid Credential With Id: %d And Password: %s", fieldOne,fieldTwo));
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
    }
}
