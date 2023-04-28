package com.user.service.Exceptions;

import com.user.service.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {

            APIResponse apiResponse = APIResponse.builder().message(exception.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
