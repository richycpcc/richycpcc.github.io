package io.catalyte.springboot.exceptions;

import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static io.catalyte.springboot.constants.StringConstants.*;


/**
     * A controller advice allows you to use exactly the same exception handling techniques but apply
     * them across the whole application, not just to an individual controller. You can think of them as
     * an annotation driven interceptor. More info: https://www.baeldung.com/exception-handling-for-rest-with-spring
     */
    @ControllerAdvice
    public class ExceptionController {

        @ExceptionHandler(ResourceNotFound.class)
        protected ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFound exception) {
            ExceptionResponse response =
                    new ExceptionResponse(NOT_FOUND, new Date(), exception.getMessage());

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(ServiceUnavailable.class)
        protected ResponseEntity<ExceptionResponse> serverError(ServiceUnavailable exception) {
            ExceptionResponse response =
                    new ExceptionResponse(SERVER_ERROR, new Date(), exception.getMessage());

            return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
        }

        private String parseMessage(MethodArgumentNotValidException ex) {
            List<FieldError> errors = ex.getBindingResult().getFieldErrors();
            StringBuilder message = new StringBuilder();
            for (FieldError err : errors) {
                message.append(err.getDefaultMessage());
                message.append(" ");
            }
            return message.toString().trim();
        }
        @ExceptionHandler(UniqueFieldViolation.class)
        protected ResponseEntity<ExceptionResponse> conflict(UniqueFieldViolation exception) {

            ExceptionResponse response =
                    new ExceptionResponse(BAD_DATA, new Date(), exception.getMessage());

            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

    @ExceptionHandler(BadRequest.class)
    protected ResponseEntity<ExceptionResponse> badRequest(BadRequest exception) {
        ExceptionResponse response = new ExceptionResponse(BAD_REQUEST, new Date(),
                exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



}
