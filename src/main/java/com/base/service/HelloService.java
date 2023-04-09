package com.base.service;

import com.base.domain.HelloRequest;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String hello(HelloRequest helloRequest) {
        return "Hello, " + helloRequest.getName();
    }
}
