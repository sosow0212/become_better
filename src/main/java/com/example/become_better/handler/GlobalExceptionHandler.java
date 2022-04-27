package com.example.become_better.handler;


import com.example.become_better.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // ?
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    private ResponseDto<String> handleArgumentException(Exception e) {
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        // INTERNAL_SERVER_ERROR = 500 값임
    }
}
