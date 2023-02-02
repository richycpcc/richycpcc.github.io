package io.catalyte.training.springboot.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="The employee isn't in the system")
public class EmployeeNotFound extends RuntimeException {

}
