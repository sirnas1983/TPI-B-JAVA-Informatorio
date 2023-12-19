package com.informatorio.java.exceptions;

import com.informatorio.java.dto.response.ErrorRespuestaDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String,String> validacionesError = new HashMap<>();
        List<ObjectError> validacionesErroresList = ex.getBindingResult().getAllErrors();

        for (ObjectError error: validacionesErroresList) {
            String nombreDeCampo = ((FieldError) error).getField();
            String mensajeValidacion = error.getDefaultMessage();
            validacionesError.put(nombreDeCampo,mensajeValidacion);
        }

        return new ResponseEntity<>(validacionesError, BAD_REQUEST);
    }

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
