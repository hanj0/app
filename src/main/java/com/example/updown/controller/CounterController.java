package com.example.updown.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.updown.service.CounterService;
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
        return counterService.increase();
    }

    @PostMapping("/down")
    public int decrease() {
        return counterService.decrease();
    }
}
