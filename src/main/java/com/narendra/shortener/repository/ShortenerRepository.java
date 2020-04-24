package com.narendra.shortener.repository;

import com.narendra.shortener.entity.Shortener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenerRepository extends JpaRepository<Shortener, Long> {
    Optional<Shortener> findFirstByValue(String value);
}
