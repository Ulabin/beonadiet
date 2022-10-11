package com.beonadiet.beonadiet.controller.product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxMinisaladDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSnackDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSoupDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladCarbsDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladProteinDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladSauceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladToppingDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladVegetableDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichBreadDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichCheeseDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichMeatDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichSauceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichToppingDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichVegetableDTO;
import com.beonadiet.beonadiet.dto.product.ProductDTO;
import com.beonadiet.beonadiet.dto.product.ProductImageDTO;
import com.beonadiet.beonadiet.entity.product.ProductImage;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxMinisaladService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxRiceService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSidedishService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSnackService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSoupService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladCarbsService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladSauceService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladToppingService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladVegetableService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichBreadService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichCheeseService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichMeatService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichSauceService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichToppingService;
import com.beonadiet.beonadiet.service.product.MyOwnSandwichVegetableService;
import com.beonadiet.beonadiet.service.product.ProductService;
import com.beonadiet.beonadiet.service.product.MyOwnSaladProteinService;
import com.beonadiet.beonadiet.vo.NutritionInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/element_regist")
@RequiredArgsConstructor
public class ElementRegistController {
    private final MyOwnLunchboxRiceService service;
    private final MyOwnLunchboxSidedishService sideDishService;
    private final MyOwnLunchboxSoupService soupService;
    private final MyOwnLunchboxMinisaladService minisaladService;
    private final MyOwnLunchboxSnackService snackService;
    private final MyOwnSaladToppingService toppingService;
    private final MyOwnSaladProteinService proteinService;
    private final MyOwnSaladSauceService sauceService;
    private final MyOwnSaladCarbsService carbsService;
    private final MyOwnSaladVegetableService vegetableService;
    private final MyOwnSandwichVegetableService sandwichVegetableService;
    private final MyOwnSandwichToppingService sandwichToppingService;
    private final MyOwnSandwichCheeseService sandwichCheeseService;
    private final MyOwnSandwichMeatService sandwichMeatService;
    private final MyOwnSandwichBreadService sandwichBreadService;
    private final MyOwnSandwichSauceService sandwichSauceService;
    private final ProductService productService;

    @Value("${com.beonadiet.upload.path}")
    private String uploadPath;

    @GetMapping("/my_own_lunchbox/rice")
    public String riceRegister(){
        return "/element_regist/my_own_lunchbox_rice";
    }

    @GetMapping("/my_own_lunchbox/sidedish")
    public String sidedishRegister(){
        return "/element_regist/my_own_lunchbox_sidedish";
    }

    @GetMapping("/my_own_lunchbox/soup")
    public String soupRegister(){
        return "/element_regist/my_own_lunchbox_soup";
    }

    @GetMapping("/my_own_lunchbox/minisalad")
    public String minisaladRegister(){
        return "/element_regist/my_own_lunchbox_minisalad";
    }

    @GetMapping("/my_own_lunchbox/snack")
    public String snackRegister(){
        return "/element_regist/my_own_lunchbox_snack";
    }

    @GetMapping("/my_own_salad/topping")
    public String toppingRegister(){
        return "/element_regist/my_own_salad_topping";
    }

    @GetMapping("/my_own_salad/carbs")
    public String carbsRegister(){
        return "/element_regist/my_own_salad_carbs";
    }

    @GetMapping("/my_own_salad/vegetable")
    public String vegetableRegister(){
        return "/element_regist/my_own_salad_vegetable";
    }

    @GetMapping("/my_own_salad/protein")
    public String proteinRegister(){
        return "/element_regist/my_own_salad_protein";
    }

    @GetMapping("/my_own_salad/sauce")
    public String sauceRegister(){
        return "/element_regist/my_own_salad_sauce";
    }

    @GetMapping("/my_own_sandwich/sauce")
    public String sandwichSauceRegister(){
        return "/element_regist/my_own_sandwich_sauce";
    }

    @GetMapping("/my_own_sandwich/vegetable")
    public String sandwichVegetableRegister(){
        return "/element_regist/my_own_sandwich_vegetable";
    }

    @GetMapping("/my_own_sandwich/topping")
    public String sandwichToppingRegister(){
        return "/element_regist/my_own_sandwich_topping";
    }

    @GetMapping("/my_own_sandwich/cheese")
    public String sandwichCheeseRegister(){
        return "/element_regist/my_own_sandwich_cheese";
    }

    @GetMapping("/my_own_sandwich/meat")
    public String sandwichMeatRegister(){
        return "/element_regist/my_own_sandwich_meat";
    }

    @GetMapping("/my_own_sandwich/bread")
    public String sandwichBreadRegister(){
        return "/element_regist/my_own_sandwich_bread";
    }

    @GetMapping("/product")
    public String productRegister(){
        return "/element_regist/product";
    }

    @PostMapping("/my_own_lunchbox/rice")
    public String uploadFileAndRegister_rice(@RequestParam("image") MultipartFile img, MyOwnLunchboxRiceDTO riceDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO riceImgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        riceDTO.setImageDTO(riceImgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            riceDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        service.register(riceDTO);

        return "redirect:/element_regist/my_own_lunchbox/rice";
    }

    @PostMapping("/my_own_lunchbox/sidedish")
    public String uploadFileAndRegister_sidedish(@RequestParam("image") MultipartFile img, MyOwnLunchboxSidedishDTO sidedishDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO sidedishImgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        sidedishDTO.setImageDTO(sidedishImgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            sidedishDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sideDishService.register(sidedishDTO);

        return "redirect:/element_regist/my_own_lunchbox/sidedish";
    }

    @PostMapping("/my_own_lunchbox/soup")
    public String uploadFileAndRegister_soup(@RequestParam("image") MultipartFile img, MyOwnLunchboxSoupDTO soupDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO riceImgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        soupDTO.setImageDTO(riceImgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            soupDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        soupService.register(soupDTO);

        return "redirect:/element_regist/my_own_lunchbox/soup";
    }

    @PostMapping("/my_own_lunchbox/minisalad")
    public String uploadFileAndRegister_minisalad(@RequestParam("image") MultipartFile img, MyOwnLunchboxMinisaladDTO minisaladDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO minisaladImgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        minisaladDTO.setImageDTO(minisaladImgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            minisaladDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        minisaladService.register(minisaladDTO);

        return "redirect:/element_regist/my_own_lunchbox/minisalad";
    }

    @PostMapping("/my_own_lunchbox/snack")
    public String uploadFileAndRegister_snack(@RequestParam("image") MultipartFile img, MyOwnLunchboxSnackDTO snackDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO snackImgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        snackDTO.setImageDTO(snackImgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            snackDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        snackService.register(snackDTO);

        return "redirect:/element_regist/my_own_lunchbox/snack";
    }

    @PostMapping("/my_own_salad/topping")
    public String uploadFileAndRegister_topping(@RequestParam("image") MultipartFile img, MyOwnSaladToppingDTO toppingDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        toppingDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            toppingDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        toppingService.register(toppingDTO);

        return "redirect:/element_regist/my_own_salad/topping";
    }

    @PostMapping("/my_own_salad/vegetable")
    public String uploadFileAndRegister_vegetable(@RequestParam("image") MultipartFile img, MyOwnSaladVegetableDTO vegetableDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        vegetableDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            vegetableDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        vegetableService.register(vegetableDTO);

        return "redirect:/element_regist/my_own_salad/vegetable";
    }

    @PostMapping("/my_own_salad/protein")
    public String uploadFileAndRegister_protein(@RequestParam("image") MultipartFile img, MyOwnSaladProteinDTO proteinDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        proteinDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            proteinDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        proteinService.register(proteinDTO);

        return "redirect:/element_regist/my_own_salad/protein";
    }

    @PostMapping("/my_own_salad/sauce")
    public String uploadFileAndRegister_sauce(@RequestParam("image") MultipartFile img, MyOwnSaladSauceDTO sauceDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        sauceDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            sauceDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sauceService.register(sauceDTO);

        return "redirect:/element_regist/my_own_salad/sauce";
    }

    @PostMapping("/my_own_salad/carbs")
    public String uploadFileAndRegister_carbs(@RequestParam("image") MultipartFile img, MyOwnSaladCarbsDTO carbsDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        carbsDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            carbsDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        carbsService.register(carbsDTO);

        return "redirect:/element_regist/my_own_salad/carbs";
    }

    @PostMapping("/my_own_sandwich/bread")
    public String uploadFileAndRegister_bread(@RequestParam("image") MultipartFile img, MyOwnSandwichBreadDTO breadDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        breadDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            breadDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sandwichBreadService.register(breadDTO);

        return "redirect:/element_regist/my_own_sandwich/bread";
    }

    @PostMapping("/my_own_sandwich/cheese")
    public String uploadFileAndRegister_cheese(@RequestParam("image") MultipartFile img, MyOwnSandwichCheeseDTO cheeseDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        cheeseDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            cheeseDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sandwichCheeseService.register(cheeseDTO);

        return "redirect:/element_regist/my_own_sandwich/cheese";
    }

    @PostMapping("/my_own_sandwich/meat")
    public String uploadFileAndRegister_meat(@RequestParam("image") MultipartFile img, MyOwnSandwichMeatDTO meatDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        meatDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            meatDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sandwichMeatService.register(meatDTO);

        return "redirect:/element_regist/my_own_sandwich/meat";
    }

    @PostMapping("/my_own_sandwich/sauce")
    public String uploadFileAndRegister_sauce(@RequestParam("image") MultipartFile img, MyOwnSandwichSauceDTO sauceDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        sauceDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            sauceDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sandwichSauceService.register(sauceDTO);

        return "redirect:/element_regist/my_own_sandwich/sauce";
    }

    @PostMapping("/my_own_sandwich/topping")
    public String uploadFileAndRegister_topping(@RequestParam("image") MultipartFile img, MyOwnSandwichToppingDTO toppingDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        toppingDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            toppingDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sandwichToppingService.register(toppingDTO);

        return "redirect:/element_regist/my_own_sandwich/topping";
    }

    @PostMapping("/my_own_sandwich/vegetable")
    public String uploadFileAndRegister_vegetable(@RequestParam("image") MultipartFile img, MyOwnSandwichVegetableDTO vegetableDTO, @ModelAttribute NutritionInfoVo niVo){
        String fileName = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveName = uploadPath+File.separator+uuid+"_"+fileName;
        
        Path savePath = Paths.get(saveName);
        try {
            img.transferTo(savePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        MyOwnElementImgDTO imgDTO = MyOwnElementImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

        vegetableDTO.setImageDTO(imgDTO);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(niVo);
            vegetableDTO.setNutrition_info(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sandwichVegetableService.register(vegetableDTO);

        return "redirect:/element_regist/my_own_sandwich/vegetable";
    }

    @PostMapping("/product")
    public String uploadFileAndRegister_product(@RequestParam("image") MultipartFile[] imgFiles, ProductDTO productDTO, @ModelAttribute NutritionInfoVo niVo){
        List<ProductImageDTO> imgList = new ArrayList<>();

        for (MultipartFile img : imgFiles) {
            String fileName = img.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String folderPath = makeFolder();

            String saveName = uploadPath+File.separator+folderPath+File.separator+uuid+"_"+fileName;

            Path savePath = Paths.get(saveName);

            try {
                img.transferTo(savePath);
                ProductImageDTO imgDTO = ProductImageDTO.builder().folderPath(folderPath).imgName(fileName).path(saveName).uuid(uuid).build();
                imgList.add(imgDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productDTO.setImageDTOList(imgList);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(niVo);
            productDTO.setNutritionInfo(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        productService.register(productDTO);

        return "redirect:/element_regist/product";
    }

    private String makeFolder() {
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String folderPath = str.replace("/", File.separator);
        File uploadPathFolder = new File(uploadPath, folderPath);
        if(uploadPathFolder.exists() == false){
          uploadPathFolder.mkdirs();
        }
        return folderPath;
    }
}