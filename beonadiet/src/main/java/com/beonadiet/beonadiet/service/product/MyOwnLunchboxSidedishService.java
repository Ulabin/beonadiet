package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishImgDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSidedish;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSidedishImage;

public interface MyOwnLunchboxSidedishService {
    public void register(MyOwnLunchboxSidedishDTO sidedishDTO); 
    public List<MyOwnLunchboxSidedishDTO> findAllSidedish();

    default MyOwnLunchboxSidedishDTO entityToDTO(MyOwnLunchboxSidedish sidedish, MyOwnLunchboxSidedishImage sidedishImg){
        MyOwnLunchboxSidedishDTO lunchboxSidedishDTO = 
        MyOwnLunchboxSidedishDTO.builder().id(sidedish.getId())
                                        .name(sidedish.getName())
                                        .explanation(sidedish.getExplanation())
                                        .nutrition_info(sidedish.getNutrition_info())
                                        .one_serving(sidedish.getOne_serving())
                                        .sales_count(sidedish.getSales_count())
                                        .category(sidedish.getCategory())
                                        .regDate(sidedish.getRegDate())
                                        .modDate(sidedish.getModDate())
                                        .imageDTO(MyOwnLunchboxSidedishImgDTO.builder()
                                            .imgName(sidedishImg.getImgName())
                                            .path(sidedishImg.getPath())
                                            .uuid(sidedishImg.getUuid()).build())
                                        .build();
        return lunchboxSidedishDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnLunchboxSidedishDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnLunchboxSidedish sidedish = MyOwnLunchboxSidedish.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .sales_count(dto.getSales_count())
                                    .category(dto.getCategory())
                                    .build();
        entityMap.put("sidedish", sidedish);
        
        MyOwnLunchboxSidedishImgDTO imgDTO = dto.getImageDTO();
        MyOwnLunchboxSidedishImage sidedishImg = MyOwnLunchboxSidedishImage.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnLunchboxSidedish(sidedish)
                                            .build();
        entityMap.put("sidedishImg",sidedishImg);

        return entityMap;
    }
}
