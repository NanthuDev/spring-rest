package com.nklearning.demorest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppTestController {

    @GetMapping
    public String home(){
        return "Hai welcome to Demo app";
    }
}
