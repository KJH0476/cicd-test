package cicd.sin_1.ProjCICD1.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test1() {
        return "Hello World!, BLUE API1, RUN 8080";
    }

    public String test2() {
        return "Hello World!, BLUE API2, RUNT 8080";
    }
}
