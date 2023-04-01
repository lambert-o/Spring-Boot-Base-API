package com.base.service;

import com.base.domain.EchoRequest;
import org.springframework.stereotype.Service;

@Service
public class EchoService {
    public String echo(EchoRequest echoRequest) {
        return "Echoing - " + echoRequest.getEcho();
    }
}
