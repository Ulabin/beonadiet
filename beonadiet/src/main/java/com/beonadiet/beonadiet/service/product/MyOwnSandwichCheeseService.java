package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichCheeseDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichCheese;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichCheeseImg;

public interface MyOwnSandwichCheeseService {
    public void register(MyOwnSandwichCheeseDTO cheeseDTO); 
    public List<MyOwnSandwichCheeseDTO> findAllCheese();

    default MyOwnSandwichCheeseDTO entityToDTO(MyOwnSandwichCheese cheese, MyOwnSandwichCheeseImg cheeseImg){
        MyOwnSandwichCheeseDTO cheeseDTO = 
        MyOwnSandwichCheeseDTO.builder().id(cheese.getId())
                                        .name(cheese.getName())
                                        .explanation(cheese.getExplanation())
                                        .nutrition_info(cheese.getNutrition_info())
                                        .one_serving(cheese.getOne_serving())
                                        .regDate(cheese.getRegDate())
                                        .modDate(cheese.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(cheeseImg.getImgName())
                                            .path(cheeseImg.getPath())
                                            .uuid(cheeseImg.getUuid()).build())
                                        .build();
        return cheeseDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSandwichCheeseDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSandwichCheese cheese = MyOwnSandwichCheese.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("cheese", cheese);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSandwichCheeseImg cheeseImg = MyOwnSandwichCheeseImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSandwichCheese(cheese)
                                            .build();
        entityMap.put("cheeseImg",cheeseImg);

        return entityMap;
    }
}
