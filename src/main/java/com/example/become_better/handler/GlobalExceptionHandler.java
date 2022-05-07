package com.example.become_better.handler;


import com.example.become_better.dto.GlobalErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // ?
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    private GlobalErrorResponseDto<String> handleArgumentException(Exception e) {
        return new GlobalErrorResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        // INTERNAL_SERVER_ERROR = 500 값임
    }
}
