package com.example.app.service;

import com.example.app.domain.Counter;
import com.example.app.repository.CounterRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {

    private final CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @PostConstruct
    public void init() {
        if(counterRepository.count() == 0) {
            Counter c = new Counter(0);
            counterRepository.save(c);
        }
    }

    @Transactional(readOnly = true)
    public int getCount() {
        return counterRepository.findById(1L)
                .orElseThrow()
                .getCount();
    }

    @Transactional
    public void increase() {
        counterRepository.increase(1L);
    }

    @Transactional
    public void decrease() {
        counterRepository.decrease(1L);
    }
}
