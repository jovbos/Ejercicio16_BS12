package com.bosonit.BP1.application.exceptions.exception422;

import com.bosonit.BP1.application.exceptions.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomErrorHandler422 {

    @ExceptionHandler(value={CustomErrorRequest422.class})
    public ResponseEntity<Object> handlerError(CustomErrorRequest422 e) {
        Integer request = 422;
        CustomError customError = new CustomError(
                e.getMessage(),
                422,
                ZonedDateTime.now(ZoneId.of("UTC+1"))
        );
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
