package com.base.controller;

import com.base.domain.HelloRequest;
import com.base.service.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class HelloWorldController {
    @Operation(summary = "Returns a hello response")
    @GetMapping("/hello")
    public String hello(@ModelAttribute HelloRequest helloRequest) {
        HelloService helloService = new HelloService();
        log.info("Calling hello service");
        return helloService.hello(helloRequest);
    }
}
