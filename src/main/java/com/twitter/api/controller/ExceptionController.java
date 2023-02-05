package com.twitter.api.controller;

import com.twitter.api.controller.rdto.response.ErrorRSRDTO;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorRSRDTO> badRequestException(BindException errorException) {
        val messageErrorList = errorException.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(toList());

        return status(BAD_REQUEST).body(buildErrorRSRDTO(BAD_REQUEST.toString(), messageErrorList));
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ErrorRSRDTO> restClientException(RestClientException errorException) {
        return status(INTERNAL_SERVER_ERROR)
                .body(buildErrorRSRDTO(INTERNAL_SERVER_ERROR.toString(), asList(errorException.getLocalizedMessage())));
    }

    private ErrorRSRDTO buildErrorRSRDTO(String code, List<String> messageError) {
        return ErrorRSRDTO.builder()
                .code(code)
                .messageError(messageError)
                .build();
    }
}
