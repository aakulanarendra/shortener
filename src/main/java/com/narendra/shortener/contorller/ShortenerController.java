package com.narendra.shortener.contorller;

import com.narendra.shortener.model.ShortenerRequest;
import com.narendra.shortener.service.ShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ShortenerController {

    final ShortenerService shortenerService;

    @Autowired
    public ShortenerController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @PostMapping("shortenerUrl")
    public String generateShortend(@RequestBody ShortenerRequest shortenerRequest){
       return shortenerService.generateShortener(shortenerRequest.getLongUrl());
    }
}
