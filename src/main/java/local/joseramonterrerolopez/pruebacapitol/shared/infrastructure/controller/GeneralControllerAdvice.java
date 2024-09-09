package local.joseramonterrerolopez.pruebacapitol.shared.infrastructure.controller;

import local.joseramonterrerolopez.pruebacapitol.shared.domain.exception.NotFoundException;
import org.openapitools.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;

@ControllerAdvice
public class GeneralControllerAdvice {

    // Handle Bad Request (400)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = String.format("Parameter '%s' should be of type %s", ex.getName(), Objects.requireNonNull(ex.getRequiredType()).getSimpleName());
        return ResponseEntity.badRequest().body(errorBody(HttpStatus.BAD_REQUEST, message));
    }

    // Handle Bad Request (400)
    @ExceptionHandler(MissingServletRequestParameterException .class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleMissingParams(MissingServletRequestParameterException  ex) {
        String message = String.format("The '%s' parameter is missing", ex.getParameterName());
        return ResponseEntity.badRequest().body(errorBody(HttpStatus.BAD_REQUEST, message));
    }

    // Handle Not Found (404)
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(NotFoundException ex) {
        String message = String.format("'%s' not found", ex.getResourceName());
        return new ResponseEntity<>(errorBody(HttpStatus.NOT_FOUND, message), HttpStatus.NOT_FOUND);
    }

    // Handle Not Found (404)
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleUrlNotFound(NoResourceFoundException ex) {
        return new ResponseEntity<>(errorBody(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    // Handle Internal Server Error (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception ex) {
        return ResponseEntity.internalServerError().body(errorBody(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"));
    }

    private static ErrorResponse errorBody(HttpStatus httpStatus, String message)
    {
        return new ErrorResponse().code(httpStatus.value()).message(message);
    }
}
