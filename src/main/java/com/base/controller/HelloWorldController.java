package com.base.controller;

import com.base.domain.HelloRequest;
import com.base.service.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private static final Logger logger = LogManager.getLogger(HelloWorldController.class);
    @Operation(summary = "Echos a response")
    @GetMapping("/hello")
    public String hello(@ModelAttribute HelloRequest helloRequest) {
        HelloService helloService = new HelloService();
        logger.info("Calling hello service");
        return helloService.hello(helloRequest);
    }
}
