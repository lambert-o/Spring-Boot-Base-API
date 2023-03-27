package com.base.controllers;

import com.base.domain.EchoRequest;
import com.base.services.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @GetMapping("/echo")
    public String echo(@RequestParam("echo") EchoRequest echoRequest) {
        EchoService echoService = new EchoService();
        System.out.println("Calling echo service");
        return echoService.echo(echoRequest);
    }
}
