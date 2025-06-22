package com.soumya.student_db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soumya.student_db.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Optional<Student> findByRollNo(Integer rollNo);
}
