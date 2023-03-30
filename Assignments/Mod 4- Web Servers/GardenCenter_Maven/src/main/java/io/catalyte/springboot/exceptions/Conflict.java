package io.catalyte.springboot.exceptions;

public class Conflict extends UniqueFieldViolation {
    public Conflict() {
    }

    public Conflict(String message) {
        super(message);
    }
}

