package cicd.sin_1.ProjCICD1.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test1() {
        return "Hello World!, GREEN API1, RUN 8081";
    }

    public String test2() {
        return "Hello World!, GREEN API2, RUNT 8081";
    }
}
