package io.catalyte.training.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
    @RestController
    public class HomeController
    {
       @RequestMapping(value = "/", method = RequestMethod.GET)
        public String helloWorld()
       {
           return "Hello World!";
       }

      /* // unncessary method
       @RequestMapping (value="/MissingPage", method = RequestMethod.GET)
       */

        @GetMapping("/MissingPage")
        public String missingPage()
       {
           return "... Then I was found...";
       }

        @GetMapping("/SecondPage")
        public String secondPage()
        {
            return "And then there were two!";
        }




    }

