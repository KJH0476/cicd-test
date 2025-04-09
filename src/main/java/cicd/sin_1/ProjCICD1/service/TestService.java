package cicd.sin_1.ProjCICD1.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test1() {
        return "Hello World!, test1(), CICD 1";
    }

    public String test2() {
        return "Hello World!, test2(), CICD 1";
    }
}
