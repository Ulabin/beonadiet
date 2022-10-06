package com.beonadiet.beonadiet.controller.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishDTO;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxRiceService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSidedishService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/my_own_series")
@RequiredArgsConstructor
public class MyOwnLunchboxController {
    private final MyOwnLunchboxRiceService service;
    private final MyOwnLunchboxSidedishService sidedishService;

    @GetMapping("/lunchbox/step1")
    public String MyOwnLunchboxStep1(){
        return "my_own_series/lunchbox/my_own_lunchbox_step1";
    } 
 
    @PostMapping("/lunchbox/step2")
    public String MyOwnLunchboxStep2Post(Model model){
        List<MyOwnLunchboxRiceDTO> dtolist= service.findAllRice();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step2";
    }

    @GetMapping("/lunchbox/step2")
    public String MyOwnLunchboxStep2Get(Model model){
        List<MyOwnLunchboxRiceDTO> dtolist= service.findAllRice();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step2";
    }

    @PostMapping("/lunchbox/step3")
    public String myOwnLunchboxStep3Post(Model model){
        List<MyOwnLunchboxSidedishDTO> dtolist= sidedishService.findAllSidedish();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step3";
    }

    @GetMapping("/lunchbox/step3")
    public String MyOwnLunchboxStep3Get(Model model){
        List<MyOwnLunchboxSidedishDTO> dtolist= sidedishService.findAllSidedish();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step3";
    }
}
