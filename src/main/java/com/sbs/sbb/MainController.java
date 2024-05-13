package com.sbs.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    public String index() {
        return "list";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

    @GetMapping("/test2")
    public String test2() {
        return "테스트";
    }
}
