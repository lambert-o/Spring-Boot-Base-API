package com.base.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnValidResponseWhenRequestValid() throws Exception {
        String name = "Owen Lambert";
        mockMvc.perform(get("/hello")
                        .param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Owen Lambert"));
    }
}
