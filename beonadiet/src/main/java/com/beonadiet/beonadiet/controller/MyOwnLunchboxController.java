package com.beonadiet.beonadiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beonadiet.beonadiet.service.MyOwnLunchboxRiceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/my_own_series")
@RequiredArgsConstructor
public class MyOwnLunchboxController {
    private final MyOwnLunchboxRiceService service;

    @GetMapping("/lunchbox/step1")
    public String MyOwnLunchboxStep1(){
        return "my_own_series/lunchbox/my_own_lunchbox_step1";
    }
 
    @PostMapping("/lunchbox/step2")
    public String MyOwnLunchboxStep2Post(){
        return "my_own_series/lunchbox/my_own_lunchbox_step2";
    }

    @GetMapping("/lunchbox/step2")
    public String MyOwnLunchboxStep2Get(){
        return "my_own_series/lunchbox/my_own_lunchbox_step2";
    }
}
