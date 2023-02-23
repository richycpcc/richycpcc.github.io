package io.catalyte.springboot;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerRunner {
    private static Logger logger = LoggerFactory.getLogger(ServerRunner.class);
    public static void main(String[] args) {
        logger.trace("This is a trace message");
        logger.debug("This is a debugging message");
        logger.info("This is an information message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        SpringApplication.run(ServerRunner.class, args);

    }
}