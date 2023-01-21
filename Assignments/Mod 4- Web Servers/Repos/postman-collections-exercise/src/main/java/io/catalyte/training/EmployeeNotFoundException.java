package io.catalyte.training;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    value = HttpStatus.NOT_FOUND,
    reason = "An employee with the given id was not located within the system.")
public class EmployeeNotFoundException extends RuntimeException {

}
