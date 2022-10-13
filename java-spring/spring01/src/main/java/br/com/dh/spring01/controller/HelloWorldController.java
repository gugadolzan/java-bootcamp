package br.com.dh.spring01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/name/{name}")
    public String getHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}
