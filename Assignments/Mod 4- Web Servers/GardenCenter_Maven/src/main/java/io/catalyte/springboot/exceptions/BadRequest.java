package io.catalyte.springboot.exceptions;

public class BadRequest extends RuntimeException{


    public BadRequest() {
    }

    public BadRequest(String message) {
        super(message);
    }

}
