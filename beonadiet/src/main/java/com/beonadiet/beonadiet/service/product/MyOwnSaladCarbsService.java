package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladCarbsDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladCarbs;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladCarbsImg;

public interface MyOwnSaladCarbsService {
    public void register(MyOwnSaladCarbsDTO carbsDTO); 
    public List<MyOwnSaladCarbsDTO> findAllCarbs();

    default MyOwnSaladCarbsDTO entityToDTO(MyOwnSaladCarbs carbs, MyOwnSaladCarbsImg carbsImg){
        MyOwnSaladCarbsDTO carbsDTO = 
        MyOwnSaladCarbsDTO.builder().id(carbs.getId())
                                        .name(carbs.getName())
                                        .explanation(carbs.getExplanation())
                                        .nutrition_info(carbs.getNutrition_info())
                                        .one_serving(carbs.getOne_serving())
                                        .regDate(carbs.getRegDate())
                                        .modDate(carbs.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(carbsImg.getImgName())
                                            .path(carbsImg.getPath())
                                            .uuid(carbsImg.getUuid()).build())
                                        .build();
        return carbsDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSaladCarbsDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSaladCarbs carbs = MyOwnSaladCarbs.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("carbs", carbs);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSaladCarbsImg carbsImg = MyOwnSaladCarbsImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSaladCarbs(carbs)
                                            .build();
        entityMap.put("carbsImg",carbsImg);

        return entityMap;
    }
}
