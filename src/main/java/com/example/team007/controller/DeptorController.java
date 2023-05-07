package com.example.team007.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping
public class DeptorController {

    @GetMapping("/demo")
    public String demo(){
         return "hello guys";
    }
}
