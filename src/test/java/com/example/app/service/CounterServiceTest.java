package com.example.app.service;

import com.example.app.domain.Counter;
import com.example.app.repository.CounterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class CounterServiceTest {

    @Autowired
    private CounterService counterService;

    @Autowired
    private CounterRepository counterRepository;

    @BeforeEach
    void setUp() {
        Counter counter = counterRepository.findById(1L).orElse(null);
        if (counter == null) {
            counterRepository.save(new Counter(0));
        } else {
            counter.setCount(0);
        }
    }

    @Test
    void 증가() {
        int before = counterService.getCount();
        counterService.increase();
        int after = counterService.getCount();

        assertThat(after).isEqualTo(before + 1);
    }

    @Test
    void 감소() {
        int before = counterService.getCount();
        counterService.decrease();
        int after = counterService.getCount();

        assertThat(after).isEqualTo(before - 1);
    }
}