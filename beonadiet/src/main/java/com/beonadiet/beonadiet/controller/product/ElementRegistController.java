package com.beonadiet.beonadiet.controller.product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishImgDTO;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxRiceService;
import com.beonadiet.beonadiet.service.product.MyOwnLunchboxSidedishService;
import com.beonadiet.beonadiet.vo.NutritionInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/element_regist")
@RequiredArgsConstructor
public class ElementRegistController {
    private final MyOwnLunchboxRiceService service;
    private final MyOwnLunchboxSidedishService sideDishService;

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

        MyOwnLunchboxRiceImgDTO riceImgDTO = MyOwnLunchboxRiceImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

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

        MyOwnLunchboxSidedishImgDTO sidedishImgDTO = MyOwnLunchboxSidedishImgDTO.builder().imgName(fileName).path(saveName).uuid(uuid).build();

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
}