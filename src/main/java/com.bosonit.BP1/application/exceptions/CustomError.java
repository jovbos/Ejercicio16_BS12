package com.bosonit.BP1.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Date;

@AllArgsConstructor
@Data
public class CustomError{

    private final String message;

    private final Integer httpStatus;

    private final ZonedDateTime timestamp;
}