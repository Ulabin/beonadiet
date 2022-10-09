package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichBreadDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichBread;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichBreadImg;

public interface MyOwnSandwichBreadService {
    public void register(MyOwnSandwichBreadDTO breadDTO); 
    public List<MyOwnSandwichBreadDTO> findAllBread();

    default MyOwnSandwichBreadDTO entityToDTO(MyOwnSandwichBread bread, MyOwnSandwichBreadImg breadImg){
        MyOwnSandwichBreadDTO breadDTO = 
        MyOwnSandwichBreadDTO.builder().id(bread.getId())
                                        .name(bread.getName())
                                        .explanation(bread.getExplanation())
                                        .nutrition_info(bread.getNutrition_info())
                                        .one_serving(bread.getOne_serving())
                                        .regDate(bread.getRegDate())
                                        .modDate(bread.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(breadImg.getImgName())
                                            .path(breadImg.getPath())
                                            .uuid(breadImg.getUuid()).build())
                                        .build();
        return breadDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSandwichBreadDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSandwichBread bread = MyOwnSandwichBread.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("bread", bread);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSandwichBreadImg breadImg = MyOwnSandwichBreadImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSandwichBread(bread)
                                            .build();
        entityMap.put("breadImg",breadImg);

        return entityMap;
    }
}
