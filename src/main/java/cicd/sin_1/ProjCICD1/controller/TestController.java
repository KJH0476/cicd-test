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
    public String test(Model model) {
        model.addAttribute("message", testService.test());
        return "home";
    }
}
