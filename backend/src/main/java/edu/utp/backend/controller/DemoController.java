package edu.utp.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "TDEE";
    }
    
}