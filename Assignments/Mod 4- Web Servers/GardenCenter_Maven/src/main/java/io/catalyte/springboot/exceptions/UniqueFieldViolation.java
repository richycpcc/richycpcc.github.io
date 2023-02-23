package io.catalyte.springboot.exceptions;

import org.springframework.web.client.HttpClientErrorException;

public class UniqueFieldViolation  extends RuntimeException
{
    public UniqueFieldViolation()
    {

    }
    public UniqueFieldViolation(String message)
    {

        super(message);
    }
}
