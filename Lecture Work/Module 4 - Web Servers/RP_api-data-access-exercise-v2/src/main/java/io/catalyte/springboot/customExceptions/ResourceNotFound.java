package io.catalyte.springboot.customExceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound() {

    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
