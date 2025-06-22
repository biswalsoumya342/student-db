package com.soumya.student_db.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumya.student_db.payload.ApiResponse;
import com.soumya.student_db.payload.StudentInputDto;
import com.soumya.student_db.payload.StudentLoginDto;
import com.soumya.student_db.payload.StudentOutputDto;
import com.soumya.student_db.payload.StudentUpdateDto;
import com.soumya.student_db.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
@Tag(name = "student_controller" , description = "It Contains SignUp, Login, Update And Delete Api")
public class StudentController {
    
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //Student Created
    @PostMapping("/signup")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentInputDto inputDto){
        boolean status = service.createStudent(inputDto);
        if(status){
            return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),"Student Created Successful",HttpStatus.CREATED.value()),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),"UnExpected Error occured",HttpStatus.INTERNAL_SERVER_ERROR.value()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Student
    @PostMapping("/login")
    public ResponseEntity<?> getStudent(@Valid @RequestBody StudentLoginDto loginDto){
        StudentOutputDto outputDto = service.getStudent(loginDto);
        return new ResponseEntity<>(outputDto,HttpStatus.FOUND);
    }

    //Update Student
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody StudentUpdateDto updateDto){
        service.updateStudent(updateDto);
        return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(), "Student Update Successful", HttpStatus.OK.value()),HttpStatus.OK);
    }

    //Delete Student
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(@Valid @RequestBody StudentLoginDto loginDto){
        service.deleteStudent(loginDto);
        return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(), "Student Delete Successful", HttpStatus.OK.value()),HttpStatus.OK);
    }
}
