package com.social.SocialNetwork.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.social.SocialNetwork.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {//método para tratar a exceção de objeto não encontrado
        HttpStatus status = HttpStatus.NOT_FOUND;//status HTTP 404 para indicar que o recurso não foi encontrado
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());//cria um objeto StandardError com as informações da exceção
        return ResponseEntity.status(status).body(err);
    }

}
