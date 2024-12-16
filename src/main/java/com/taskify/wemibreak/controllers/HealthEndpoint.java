package com.taskify.wemibreak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthEndpoint {
    @RequestMapping("/health")
    @ResponseBody
    String home() {
        return "Health endpoint done";
    }
}
