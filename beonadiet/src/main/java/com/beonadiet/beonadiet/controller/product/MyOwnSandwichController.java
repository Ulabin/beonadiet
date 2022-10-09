package com.beonadiet.beonadiet.controller.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beonadiet.beonadiet.dto.product.MyOwnSandwichBreadDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichCheeseDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichMeatDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichSauceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichToppingDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichVegetableDTO;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichBreadService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichCheeseService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichMeatService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichSauceService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichToppingService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichVegetableService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/my_own_series")
@RequiredArgsConstructor
public class MyOwnSandwichController {
    private final MyOwnSandwichBreadService breadService;
    private final MyOwnSandwichSauceService sauceService;
    private final MyOwnSandwichVegetableService vegetableService;
    private final MyOwnSandwichMeatService meatService;
    private final MyOwnSandwichToppingService toppingService;
    private final MyOwnSandwichCheeseService cheeseService;

    @GetMapping("/sandwich/step1")
    public String MyOwnSandwichStep1Get(Model model){
        List<MyOwnSandwichBreadDTO> dtolist= breadService.findAllBread();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step1";
    }

    @GetMapping("/sandwich/step2")
    public String MyOwnSandwichStep2Get(Model model){
        List<MyOwnSandwichVegetableDTO> dtolist= vegetableService.findAllVegetable();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step2";
    }

    @PostMapping("/sandwich/step2")
    public String MyOwnSandwichStep2Post(Model model){
        List<MyOwnSandwichVegetableDTO> dtolist= vegetableService.findAllVegetable();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step2";
    }

    @GetMapping("/sandwich/step3")
    public String MyOwnSandwichStep3Get(Model model){
        List<MyOwnSandwichCheeseDTO> dtolist= cheeseService.findAllCheese();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step3";
    }

    @PostMapping("/sandwich/step3")
    public String MyOwnSandwichStep3Post(Model model){
        List<MyOwnSandwichCheeseDTO> dtolist= cheeseService.findAllCheese();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step3";
    }

    @GetMapping("/sandwich/step4")
    public String MyOwnSandwichStep4Get(Model model){
        List<MyOwnSandwichMeatDTO> dtolist= meatService.findAllMeat();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step4";
    }

    @PostMapping("/sandwich/step4")
    public String MyOwnSandwichStep4Post(Model model){
        List<MyOwnSandwichMeatDTO> dtolist= meatService.findAllMeat();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step4";
    }

    @GetMapping("/sandwich/step5")
    public String MyOwnSandwichStep5Get(Model model){
        List<MyOwnSandwichSauceDTO> dtolist= sauceService.findAllSauce();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step5";
    }

    @PostMapping("/sandwich/step5")
    public String MyOwnSandwichStep5Post(Model model){
        List<MyOwnSandwichSauceDTO> dtolist= sauceService.findAllSauce();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step5";
    }

    @GetMapping("/sandwich/step6")
    public String MyOwnSandwichStep6Get(Model model){
        List<MyOwnSandwichToppingDTO> dtolist= toppingService.findAllTopping();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step6";
    }

    @PostMapping("/sandwich/step6")
    public String MyOwnSandwichStep6Post(Model model){
        List<MyOwnSandwichToppingDTO> dtolist= toppingService.findAllTopping();
        model.addAttribute("list", dtolist);
        return "my_own_series/sandwich/my_own_sandwich_step6";
    }

    @GetMapping("/sandwich/final")
    public String MyOwnSandwichFinalGet(Model model){
        return "my_own_series/sandwich/my_own_sandwich_final";
    }

    @PostMapping("/sandwich/final")
    public String MyOwnSandwichFinalPost(Model model){
        return "my_own_series/sandwich/my_own_sandwich_final";
    }
}
