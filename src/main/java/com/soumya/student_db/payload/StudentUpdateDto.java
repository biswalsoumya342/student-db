package com.soumya.student_db.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDto {

    @NotNull(message = "Enter Your RollNo")
    @Min(value = 100000,message = "RollNo Must Be 6 Digit Long")
    @Max(value = 999999,message = "RollNo Must Be 6 Digit Long")
    private Integer rollNo;
    
    @NotBlank(message = "Password Required For Registration!")
    private String password;
    
    @NotBlank(message = "Name Can't Be Blank!")
    @Size(min = 3, message = "Name Must Be 3 Char Long!")
    private String name;

    @Email(message = "Enter Valid Email!")
    private String email;

    @NotBlank(message = "Phone Can't Be Blank!")
    @Size(min = 10,max = 10,message = "Phone Must Be 10 Digit Long")
    private String phone;

    @NotBlank(message = "Adress Can't Be Blank!")
    private String adress;
}
