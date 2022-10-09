package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichToppingDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichTopping;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichToppingImg;

public interface MyOwnSandwichToppingService {
    public void register(MyOwnSandwichToppingDTO toppingDTO); 
    public List<MyOwnSandwichToppingDTO> findAllTopping();

    default MyOwnSandwichToppingDTO entityToDTO(MyOwnSandwichTopping topping, MyOwnSandwichToppingImg toppingImg){
        MyOwnSandwichToppingDTO toppingDTO = 
        MyOwnSandwichToppingDTO.builder().id(topping.getId())
                                        .name(topping.getName())
                                        .explanation(topping.getExplanation())
                                        .nutrition_info(topping.getNutrition_info())
                                        .one_serving(topping.getOne_serving())
                                        .regDate(topping.getRegDate())
                                        .modDate(topping.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(toppingImg.getImgName())
                                            .path(toppingImg.getPath())
                                            .uuid(toppingImg.getUuid()).build())
                                        .build();
        return toppingDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSandwichToppingDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSandwichTopping topping = MyOwnSandwichTopping.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("topping", topping);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSandwichToppingImg toppingImg = MyOwnSandwichToppingImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSandwichTopping(topping)
                                            .build();
        entityMap.put("toppingImg",toppingImg);

        return entityMap;
    }
}
