package com.sbs.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/com/sbs/sbb")
    @ResponseBody
    public String index() {
       return "방가방가!!" ;
    }
}
