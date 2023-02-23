package io.catalyte.springboot.exceptions;
import java.lang.RuntimeException;

public class ResourceNotFound extends RuntimeException
{
    public ResourceNotFound() {
    }

    public ResourceNotFound(String message) {
        super(message);
    }

}
