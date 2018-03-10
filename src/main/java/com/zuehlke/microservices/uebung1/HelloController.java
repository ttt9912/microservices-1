package com.zuehlke.microservices.uebung1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Alternativ: @RestController
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

}
