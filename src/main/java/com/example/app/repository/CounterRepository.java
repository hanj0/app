package com.example.app.repository;

import com.example.app.domain.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CounterRepository extends JpaRepository<Counter, Long> {

    @Modifying
    @Query("UPDATE Counter c SET c.count = c.count + 1 WHERE c.id = :id")
    void increase(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Counter c SET c.count = c.count - 1 WHERE c.id = :id")
    void decrease(@Param("id") Long id);
}
