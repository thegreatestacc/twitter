package com.sovliv.twitter.security.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeErrors(RuntimeException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getAllErrors().stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .findFirst()
                .orElseThrow();

        String errorMessage = String.format("поле %s %s", fieldError.getField(), fieldError.getDefaultMessage());

        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ProblemDetail handleUserAlreadyExistException(UserAlreadyExistException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(CustomUsernameNotFoundException.class)
    public ProblemDetail handleUsernameNotFoundException(CustomUsernameNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
