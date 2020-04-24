package com.narendra.shortener.controller;

import com.narendra.shortener.contorller.HomeController;
import com.narendra.shortener.service.ShortenerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @MockBean
    ShortenerService shortenerService;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() {
        Mockito.when(shortenerService.getShortenerUrlValue("1"))
                .thenReturn("https://www.tets.com/aaabbbccc");
    }


    @Test
    public void homePageTest() throws Exception {
        mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void redirectUrlTest() throws Exception {
        mockMvc.perform(get("/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("https://www.tets.com/aaabbbccc"));
    }
}
