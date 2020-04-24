package com.narendra.shortener.contorller;

import com.narendra.shortener.service.ShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    final ShortenerService shortenerService;

    @Autowired
    public HomeController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @GetMapping
    public String homePage() {
        return "index";
    }

    @GetMapping("{shortendurl}")
    public RedirectView redirectUrl(@PathVariable("shortendurl") String shortEndUrl) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(shortenerService.getShortenerUrlValue(shortEndUrl));
        return redirectView;
    }
}
