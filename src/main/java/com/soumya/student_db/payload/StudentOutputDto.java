package com.soumya.student_db.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {

    private String name;

    private Integer rollNo;

    private String email;

    private String phone;

    private String adress;

    private Long due;

}
