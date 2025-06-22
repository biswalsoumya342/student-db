package com.soumya.student_db.payload;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private LocalDateTime time;

    private String message;

    private Integer statusCode;
}
