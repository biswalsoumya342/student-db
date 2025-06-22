package com.soumya.student_db.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.soumya.student_db.exception.ResourceAlreadyExistsException;
import com.soumya.student_db.exception.ResourceNotFoundException;
import com.soumya.student_db.exception.UnautorizeAccessException;
import com.soumya.student_db.mapper.StudentMapper;
import com.soumya.student_db.model.Student;
import com.soumya.student_db.payload.StudentInputDto;
import com.soumya.student_db.payload.StudentLoginDto;
import com.soumya.student_db.payload.StudentOutputDto;
import com.soumya.student_db.payload.StudentUpdateDto;
import com.soumya.student_db.repository.StudentRepository;
import com.soumya.student_db.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;
    private final StudentMapper mapper;

    public StudentServiceImpl(StudentRepository repo,StudentMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    //Create Student
    @Override
    public boolean createStudent(StudentInputDto inputDto) {
        Student student = mapper.toStudent(inputDto);
        if(repo.findByRollNo(inputDto.getRollNo()).isPresent()){
            throw new ResourceAlreadyExistsException("Student", "RollNo", inputDto.getRollNo());
        }
        Student isSave = repo.save(student);
        if(!ObjectUtils.isEmpty(isSave)){
            return true;
        }else{
            return false;
        }
    }

    //Retrive Student
    @Override
    public StudentOutputDto getStudent(StudentLoginDto loginDto) {
        Student student = repo
        .findByRollNo(loginDto.getRollNo())
        .orElseThrow(()-> new ResourceNotFoundException("Student","RollNo",loginDto.getRollNo().toString()));
        
        
        if(student.getRollNo().equals(loginDto.getRollNo()) && student.getPassword().equals(loginDto.getPassword())){
            return mapper.toOutputDto(student);
        }else {
            throw new UnautorizeAccessException(loginDto.getRollNo(), loginDto.getPassword());
        }
    }

    @Override
    public void updateStudent(StudentUpdateDto updateDto) {
        Student student = repo
        .findByRollNo(updateDto.getRollNo())
        .orElseThrow(()-> new ResourceNotFoundException("Student","RollNo",updateDto.getRollNo().toString()));

        if(updateDto.getRollNo().equals(student.getRollNo()) && updateDto.getPassword().equals(student.getPassword())){
            student.setName(updateDto.getName());
            student.setEmail(updateDto.getEmail());
            student.setPhone(updateDto.getPhone());
            student.setAdress(updateDto.getAdress());
            repo.save(student);
        }else{
            throw new UnautorizeAccessException(updateDto.getRollNo(), updateDto.getPassword());
        }

    }

    @Override
    public void deleteStudent(StudentLoginDto loginDto) {
        Student student = repo.findByRollNo(loginDto.getRollNo()).orElseThrow(()-> new ResourceNotFoundException("Student","RollNo",loginDto.getRollNo().toString()));

        if(student.getRollNo().equals(loginDto.getRollNo()) && student.getPassword().equals(loginDto.getPassword())){
            repo.deleteById(student.getId());
        }else{
            throw new UnautorizeAccessException(loginDto.getRollNo(), loginDto.getPassword());
        }
    }
    
}
