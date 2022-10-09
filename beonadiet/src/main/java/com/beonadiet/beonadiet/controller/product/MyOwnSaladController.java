package com.beonadiet.beonadiet.controller.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beonadiet.beonadiet.service.product.MyOwnSaladCarbsService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladProteinService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladSauceService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladToppingService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladVegetableService;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladCarbsDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladProteinDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladSauceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladToppingDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladVegetableDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/my_own_series")
@RequiredArgsConstructor
public class MyOwnSaladController {
    private final MyOwnSaladCarbsService carbsService;
    private final MyOwnSaladSauceService sauceService;
    private final MyOwnSaladVegetableService vegetableService;
    private final MyOwnSaladProteinService proteinService;
    private final MyOwnSaladToppingService toppingService;

    @GetMapping("/salad/step1")
    public String MyOwnSaladStep1Get(Model model){
        List<MyOwnSaladVegetableDTO> dtolist= vegetableService.findAllVegetable();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step1";
    }

    @GetMapping("/salad/step2")
    public String MyOwnSaladStep2Get(Model model){
        List<MyOwnSaladProteinDTO> dtolist= proteinService.findAllProtein();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step2";
    }

    @PostMapping("/salad/step2")
    public String MyOwnSaladStep2Post(Model model){
        List<MyOwnSaladProteinDTO> dtolist= proteinService.findAllProtein();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step2";
    }

    @GetMapping("/salad/step3")
    public String MyOwnSaladStep3Get(Model model){
        List<MyOwnSaladToppingDTO> dtolist= toppingService.findAllTopping();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step3";
    }

    @PostMapping("/salad/step3")
    public String MyOwnSaladStep3Post(Model model){
        List<MyOwnSaladToppingDTO> dtolist= toppingService.findAllTopping();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step3";
    }

    @GetMapping("/salad/step4")
    public String MyOwnSaladStep4Get(Model model){
        List<MyOwnSaladCarbsDTO> dtolist= carbsService.findAllCarbs();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step4";
    }

    @PostMapping("/salad/step4")
    public String MyOwnSaladStep4Post(Model model){
        List<MyOwnSaladCarbsDTO> dtolist= carbsService.findAllCarbs();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step4";
    }

    @GetMapping("/salad/step5")
    public String MyOwnSaladStep5Get(Model model){
        List<MyOwnSaladSauceDTO> dtolist= sauceService.findAllSauce();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step5";
    }

    @PostMapping("/salad/step5")
    public String MyOwnSaladStep5Post(Model model){
        List<MyOwnSaladSauceDTO> dtolist= sauceService.findAllSauce();
        model.addAttribute("list", dtolist);
        return "my_own_series/salad/my_own_salad_step5";
    }

    @GetMapping("/salad/final")
    public String MyOwnSaladFinalGet(Model model){
        return "my_own_series/salad/my_own_salad_final";
    }

    @PostMapping("/salad/final")
    public String MyOwnSaladFinalPost(Model model){
        return "my_own_series/salad/my_own_salad_final";
    }
}
