package com.aniketsenvasy.sessionerppos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class EntryController {

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }
}
