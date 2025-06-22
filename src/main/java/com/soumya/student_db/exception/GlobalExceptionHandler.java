package com.soumya.student_db.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.soumya.student_db.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = UnautorizeAccessException.class)
    public ResponseEntity<?> handleUnAuthorizeAccessException(UnautorizeAccessException ex){
        return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),ex.getMessage(),HttpStatus.UNAUTHORIZED.value()),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        BindingResult result = ex.getBindingResult();
        result.getFieldErrors().forEach(error->{errors.put(error.getField(), error.getDefaultMessage());});
        return new  ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    //It Is Not handeled
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException e){
        String message = "Duplicate Entry Not Allowed!";
        return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(), message, HttpStatus.CONFLICT.value()),HttpStatus.CONFLICT);
    }

    //Replacement Of DataIntegrityViolationException will Fix later
    @ExceptionHandler(value = ResourceAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex){
        return new ResponseEntity<ApiResponse>(new ApiResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.CONFLICT.value()),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handelResourceNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),ex.getMessage(),HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
    }
}
