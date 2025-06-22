package com.soumya.student_db.mapper;

import org.mapstruct.Mapper;

import com.soumya.student_db.model.Student;
import com.soumya.student_db.payload.StudentInputDto;
import com.soumya.student_db.payload.StudentLoginDto;
import com.soumya.student_db.payload.StudentOutputDto;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    
    //To Student
    Student toStudent(StudentInputDto inputDto);

    //To Input Dto
    StudentInputDto toInputDto(Student student);

    //To OutPut Dto
    StudentOutputDto toOutputDto(Student student);

    //To Login Dto
    StudentLoginDto tLoginDto(Student student);
}
