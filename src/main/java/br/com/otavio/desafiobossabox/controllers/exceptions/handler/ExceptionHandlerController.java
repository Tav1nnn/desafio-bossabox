package br.com.otavio.desafiobossabox.controllers.exceptions.handler;

import br.com.otavio.desafiobossabox.controllers.exceptions.model.StandardError;
import br.com.otavio.desafiobossabox.services.validations.exceptions.InvalidLinkException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<StandardError>
    invalidLinkException (InvalidLinkException e, HttpServletRequest request) {
        StandardError err = new StandardError();

        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Invalid link");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
