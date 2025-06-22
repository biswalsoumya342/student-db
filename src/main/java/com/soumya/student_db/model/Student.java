package com.soumya.student_db.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "student_name", nullable = false)
    private String name;

    @Column(name = "student_rollno",unique = true, nullable = false)
    private Integer rollNo;

    @Column(name = "student_email",unique = true,nullable = false)
    private String email;

    @Column(name = "student_phone",unique = true,nullable = false)
    private String phone;

    @Column(name = "student_adress",nullable = false)
    private String adress;

    @Column(name = "student_due")
    private Long due;

    @Column(name = "student_password",nullable = false)
    private String password;
}
