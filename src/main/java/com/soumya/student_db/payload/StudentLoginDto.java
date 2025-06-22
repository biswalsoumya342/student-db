package com.soumya.student_db.payload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoginDto {

    @NotNull(message = "Enter Your RollNo")
    @Min(value = 100000,message = "RollNo Must Be 6 Digit Long")
    @Max(value = 999999,message = "RollNo Must Be 6 Digit Long")
    private Integer rollNo;

    @NotBlank(message = "Password Required For Login!")
    private String password;
}
