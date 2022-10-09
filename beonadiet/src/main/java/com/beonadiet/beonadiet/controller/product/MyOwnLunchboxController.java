package com.beonadiet.beonadiet.controller.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxMinisaladDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSnackDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSoupDTO;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxMinisaladService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxRiceService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSidedishService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSnackService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSoupService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/my_own_series")
@RequiredArgsConstructor
public class MyOwnLunchboxController {
    private final MyOwnLunchboxRiceService service;
    private final MyOwnLunchboxSidedishService sidedishService;
    private final MyOwnLunchboxSoupService soupService;
    private final MyOwnLunchboxSnackService snackService;
    private final MyOwnLunchboxMinisaladService minisaladService;

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

    @PostMapping("/lunchbox/step4/soup")
    public String myOwnLunchboxStep4SoupPost(Model model){
        List<MyOwnLunchboxSoupDTO> dtolist= soupService.findAllSoup();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step4/soup";
    }

    @GetMapping("/lunchbox/step4/soup")
    public String MyOwnLunchboxStep4SoupGet(Model model){
        List<MyOwnLunchboxSoupDTO> dtolist= soupService.findAllSoup();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step4/soup";
    }

    @GetMapping("/lunchbox/step4/minisalad")
    public String MyOwnLunchboxStep4MinisaladGet(Model model){
        List<MyOwnLunchboxMinisaladDTO> dtolist= minisaladService.findAllMinisalad();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step4/minisalad";
    }

    @PostMapping("/lunchbox/step4/minisalad")
    public String MyOwnLunchboxStep4MinisaladPost(Model model){
        List<MyOwnLunchboxMinisaladDTO> dtolist= minisaladService.findAllMinisalad();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step4/minisalad";
    }

    @GetMapping("/lunchbox/step4/snack")
    public String MyOwnLunchboxStep4SnackdGet(Model model){
        List<MyOwnLunchboxSnackDTO> dtolist= snackService.findAllSnack();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step4/snack";
    }

    @PostMapping("/lunchbox/step4/snack")
    public String MyOwnLunchboxStep4SnackPost(Model model){
        List<MyOwnLunchboxSnackDTO> dtolist= snackService.findAllSnack();
        model.addAttribute("list", dtolist);
        return "my_own_series/lunchbox/my_own_lunchbox_step4/snack";
    }

    @PostMapping("/lunchbox/final")
    public String myOwnLunchboxFinalPost(Model model){
        return "my_own_series/lunchbox/my_own_lunchbox_final";
    }

    @GetMapping("/lunchbox/final")
    public String MyOwnLunchboxFinalGet(Model model){
        return "my_own_series/lunchbox/my_own_lunchbox_final";
    }
}
