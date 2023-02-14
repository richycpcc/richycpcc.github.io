package io.catalyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServerRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServerRunner.class);
        System.out.println("Hello world!");
    }
}