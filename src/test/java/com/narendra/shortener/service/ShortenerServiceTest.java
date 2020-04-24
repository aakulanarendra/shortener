package com.narendra.shortener.service;

import com.narendra.shortener.entity.Shortener;
import com.narendra.shortener.repository.ShortenerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class ShortenerServiceTest {
    @MockBean
    ShortenerRepository shortenerRepository;

    @Autowired
    ShortenerService shortenerService;

    @Before
    public void setUp() {
        Shortener shortener = new Shortener();
        shortener.setId(1L);
        shortener.setValue("https://www.tets.com/aaabbbccc");
        Mockito.when(shortenerRepository.findFirstByValue("https://www.tets.com/aaabbbccc"))
                .thenReturn(Optional.of(shortener));
        Mockito.when(shortenerRepository.findById(any()))
                .thenReturn(Optional.of(shortener));
    }

    @TestConfiguration
    static class ShortenerServiceTestContextConfiguration {
        @Bean
        public ShortenerService shortenerService() {
            return new ShortenerService();
        }
    }

    @Test
    public void generateShortenerTest(){
        String id = shortenerService.generateShortener("https://www.tets.com/aaabbbccc");
        Assert.assertEquals("1",id);
    }

    @Test
    public void getShortenerUrlValueTest(){
        String shortUrl = shortenerService.getShortenerUrlValue("1");
        Assert.assertEquals("https://www.tets.com/aaabbbccc",shortUrl);
    }
}
