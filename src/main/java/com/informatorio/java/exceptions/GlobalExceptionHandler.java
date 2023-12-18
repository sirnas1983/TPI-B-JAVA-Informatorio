package com.informatorio.java.exceptions;

import com.informatorio.java.dto.response.ErrorRespuestaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorRespuestaDto> handleResourceNotFoundException(NotFoundException exception, WebRequest webRequest){

        ErrorRespuestaDto errorRespuestaDto = new ErrorRespuestaDto();

        errorRespuestaDto.setApiPath(webRequest.getDescription(false));
        errorRespuestaDto.setHttpStatus(HttpStatus.NOT_FOUND);
        errorRespuestaDto.setErrorMessage(exception.getMessage());
        errorRespuestaDto.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(errorRespuestaDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRespuestaDto> handleGlobalException(Exception exception, WebRequest webRequest){

        ErrorRespuestaDto errorRespuestaDto = new ErrorRespuestaDto();

        errorRespuestaDto.setApiPath(webRequest.getDescription(false));
        errorRespuestaDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorRespuestaDto.setErrorMessage(exception.getMessage());
        errorRespuestaDto.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(errorRespuestaDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
