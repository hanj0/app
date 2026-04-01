package com.example.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.service.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/counter")
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping
    public int getCount() {
        return counterService.getCount();
    }

    @PostMapping("/up")
    public int increase() {
        counterService.increase();
        return counterService.getCount();
    }

    @PostMapping("/down")
    public int decrease() {
        counterService.decrease();
        return counterService.getCount();
    }
}
