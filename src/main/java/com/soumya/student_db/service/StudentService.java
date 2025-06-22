package com.soumya.student_db.service;

import com.soumya.student_db.payload.StudentInputDto;
import com.soumya.student_db.payload.StudentLoginDto;
import com.soumya.student_db.payload.StudentOutputDto;
import com.soumya.student_db.payload.StudentUpdateDto;

public interface StudentService {
    //Create New Student
    public boolean createStudent(StudentInputDto inputDto);

    //GetStudent Dto
    public StudentOutputDto getStudent(StudentLoginDto loginDto);

    //Update Student Dto
    public void updateStudent(StudentUpdateDto updateDto);

    //Delete User
    public void deleteStudent(StudentLoginDto loginDto);
}
