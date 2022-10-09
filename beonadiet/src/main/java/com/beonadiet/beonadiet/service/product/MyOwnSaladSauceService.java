package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladSauceDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladSauce;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladSauceImg;

public interface MyOwnSaladSauceService {
    public void register(MyOwnSaladSauceDTO sauceDTO); 
    public List<MyOwnSaladSauceDTO> findAllSauce();

    default MyOwnSaladSauceDTO entityToDTO(MyOwnSaladSauce sauce, MyOwnSaladSauceImg sauceImg){
        MyOwnSaladSauceDTO sauceDTO = 
        MyOwnSaladSauceDTO.builder().id(sauce.getId())
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

    default Map<String, Object> dtoToEntity(MyOwnSaladSauceDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSaladSauce sauce = MyOwnSaladSauce.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("sauce", sauce);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSaladSauceImg sauceImg = MyOwnSaladSauceImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSaladSauce(sauce)
                                            .build();
        entityMap.put("sauceImg",sauceImg);

        return entityMap;
    }
}
