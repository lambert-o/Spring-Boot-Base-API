package com.base.controller;

import com.base.domain.request.HelloRequest;
import com.base.domain.response.HelloResponse;
import com.base.service.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloService helloService;

    @Operation(summary = "Returns a hello response")
    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> hello(@ModelAttribute HelloRequest helloRequest) {
        log.info("Calling hello service");
        String helloString = helloService.hello(helloRequest);
        HelloResponse helloResponse = new HelloResponse(helloString);
        return ResponseEntity.ok(helloResponse);
    }
}
