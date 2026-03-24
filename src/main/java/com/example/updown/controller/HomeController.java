package com.example.updown.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
class HomeController {

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }
}
