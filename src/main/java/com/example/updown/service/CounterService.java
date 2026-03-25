package com.example.updown.service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increase() {
        count++;
    }

    public void decrease() {
        count--;
    }
}
