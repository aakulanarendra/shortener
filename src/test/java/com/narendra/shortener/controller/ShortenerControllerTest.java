package com.narendra.shortener.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.narendra.shortener.contorller.ShortenerController;
import com.narendra.shortener.model.ShortenerRequest;
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
import org.springframework.util.SerializationUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ShortenerController.class)
public class ShortenerControllerTest {

    @MockBean
    ShortenerService shortenerService;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() {
        Mockito.when(shortenerService.generateShortener("https://www.tets.com/aaabbbccc"))
                .thenReturn("1");

    }

    @Test
    public void generateShortendTest() throws Exception {
        ShortenerRequest shortenerRequest = new ShortenerRequest();
        shortenerRequest.setLongUrl("https://www.tets.com/aaabbbccc");
        mockMvc.perform(post("/api/shortenerUrl")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(shortenerRequest))
                  )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("1"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
