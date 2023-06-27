package com.aniketsenvasy.sessionerppos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ClientForwardController {

    @GetMapping(value = { "/", "" })
    public String home() {
    	System.err.println("root");
        return "index";
    }

    @GetMapping(value = "/pos/**")
    public ModelAndView forward() {
    	System.err.println("pos");
        return new ModelAndView("forward:/index.html");
    }
}
