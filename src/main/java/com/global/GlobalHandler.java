package com.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> exceptionHandler(Throwable e) {
        LOGGER.error(e.getMessage(), e);
        if (e instanceof SQLException) {
            return ResponseEntity.badRequest().body("fail.connect to dev");
        }
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}