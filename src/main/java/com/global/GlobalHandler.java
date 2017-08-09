package com.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@RestControllerAdvice
public class GlobalHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Throwable e) {
        LOGGER.error(e.getMessage(), e);
        if (e instanceof SQLException | e instanceof DataAccessException) {
            return ResponseEntity.badRequest().body("The server is off.Please contact the developer");
        }
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity handleBindException(HttpServletRequest request, BindException e) {
        StringBuilder result = new StringBuilder();
        for (FieldError fieldError : e.getFieldErrors()) {
            result.append(fieldError.getField()).append(":").
                    append(fieldError.getDefaultMessage()).
                    append(System.lineSeparator());
        }
        LOGGER.error("{}?{},{}", request.getRequestURI(), request.getQueryString(), result, e.getMessage());
        return ResponseEntity.badRequest().body(result.toString());
    }


}