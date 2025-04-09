package cicd.sin_1.ProjCICD1.controller;

import cicd.sin_1.ProjCICD1.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public String test1(Model model) {
        model.addAttribute("message", testService.test1());
        return "home";
    }

    @GetMapping("/test2")
    public String test2(Model model) {
        model.addAttribute("message", testService.test2());
        return "home";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
