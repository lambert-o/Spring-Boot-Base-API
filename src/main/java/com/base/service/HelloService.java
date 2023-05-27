package com.base.service;

import com.base.domain.HelloRequest;
import com.base.repository.MyDatabaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final MyDatabaseRepository myDatabaseRepository;
    public String hello(HelloRequest helloRequest) {
        myDatabaseRepository.save(helloRequest);
        return "Hello, " + helloRequest.getName();
    }
}
