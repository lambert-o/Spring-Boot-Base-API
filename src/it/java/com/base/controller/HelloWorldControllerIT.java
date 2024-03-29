package com.base.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(properties = "spring.config.name=application-integration-test")
@AutoConfigureMockMvc
@Testcontainers
public class HelloWorldControllerIT {

  @Container
  static PostgreSQLContainer<?> postgreSQL = new PostgreSQLContainer<>();
  @Autowired
  private MockMvc mockMvc;

  @DynamicPropertySource
  static void postgreSQLProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgreSQL::getJdbcUrl);
    registry.add("spring.datasource.username", postgreSQL::getUsername);
    registry.add("spring.datasource.password", postgreSQL::getPassword);
  }

  @Test
  void shouldReturnValidResponseWhenRequestValid() throws Exception {
    String name = "Owen Lambert";
    mockMvc.perform(get("/v1/my-controller/hello").param("name", name)).andExpect(status().isOk())
        .andExpect(jsonPath("$.response").value("Hello, Owen Lambert"));
  }
}
