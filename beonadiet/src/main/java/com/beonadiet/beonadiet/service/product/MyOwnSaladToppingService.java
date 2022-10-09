package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladToppingDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladTopping;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladToppingImg;

public interface MyOwnSaladToppingService {
    public void register(MyOwnSaladToppingDTO toppingDTO); 
    public List<MyOwnSaladToppingDTO> findAllTopping();

    default MyOwnSaladToppingDTO entityToDTO(MyOwnSaladTopping topping, MyOwnSaladToppingImg toppingImg){
        MyOwnSaladToppingDTO toppingDTO = 
        MyOwnSaladToppingDTO.builder().id(topping.getId())
                                        .name(topping.getName())
                                        .explanation(topping.getExplanation())
                                        .nutrition_info(topping.getNutrition_info())
                                        .one_serving(topping.getOne_serving())
                                        .category(topping.getCategory())
                                        .regDate(topping.getRegDate())
                                        .modDate(topping.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(toppingImg.getImgName())
                                            .path(toppingImg.getPath())
                                            .uuid(toppingImg.getUuid()).build())
                                        .build();
        return toppingDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSaladToppingDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSaladTopping topping = MyOwnSaladTopping.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .category(dto.getCategory())
                                    .build();
        entityMap.put("topping", topping);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSaladToppingImg toppingImg = MyOwnSaladToppingImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSaladTopping(topping)
                                            .build();
        entityMap.put("toppingImg",toppingImg);

        return entityMap;
    }
}
