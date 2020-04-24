package com.narendra.shortener.service;

import com.narendra.shortener.entity.Shortener;
import com.narendra.shortener.repository.ShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortenerService {
    @Autowired
    ShortenerRepository shortenerRepository;

    public String generateShortener(String longUrl) {
        String id;
        Optional<Shortener> shortener = shortenerRepository.findFirstByValue(longUrl);
        if (shortener.isPresent()) {
            id = String.valueOf(shortener.get().getId());
        } else {
            Shortener shortenerReq = new Shortener(longUrl);
            Shortener shortenerSaved = shortenerRepository.save(shortenerReq);
            id = String.valueOf(shortenerSaved.getId());
        }
        return id;
    }

    public String getShortenerUrlValue(String shortendUrl) {
        Optional<Shortener> shortener = shortenerRepository.findById(Long.valueOf(shortendUrl));
        if (shortener.isPresent()) {
            return shortener.get().getValue();
        } else {
            return "No URL found for " + shortendUrl;
        }
    }
}
