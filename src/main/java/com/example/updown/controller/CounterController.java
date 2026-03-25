package com.example.updown.controller;

import com.example.updown.service.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("count", counterService.getCount());
        return "index";
    }

    @PostMapping("/up")
    public String up() {
        counterService.increase();
        return "redirect:/";
    }

    @PostMapping("/down")
    public String down() {
        counterService.decrease();
        return "redirect:/";
    }
}
