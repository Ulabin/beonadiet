package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichSauceDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichSauce;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichSauceImg;

public interface MyOwnSandwichSauceService {
    public void register(MyOwnSandwichSauceDTO sauceDTO); 
    public List<MyOwnSandwichSauceDTO> findAllSauce();

    default MyOwnSandwichSauceDTO entityToDTO(MyOwnSandwichSauce sauce, MyOwnSandwichSauceImg sauceImg){
        MyOwnSandwichSauceDTO sauceDTO = 
        MyOwnSandwichSauceDTO.builder().id(sauce.getId())
                                        .name(sauce.getName())
                                        .explanation(sauce.getExplanation())
                                        .nutrition_info(sauce.getNutrition_info())
                                        .one_serving(sauce.getOne_serving())
                                        .regDate(sauce.getRegDate())
                                        .modDate(sauce.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(sauceImg.getImgName())
                                            .path(sauceImg.getPath())
                                            .uuid(sauceImg.getUuid()).build())
                                        .build();
        return sauceDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSandwichSauceDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSandwichSauce sauce = MyOwnSandwichSauce.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("sauce", sauce);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSandwichSauceImg sauceImg = MyOwnSandwichSauceImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSandwichSauce(sauce)
                                            .build();
        entityMap.put("sauceImg",sauceImg);

        return entityMap;
    }
}
