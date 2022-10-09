package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichMeatDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichMeat;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichMeatImg;

public interface MyOwnSandwichMeatService {
    public void register(MyOwnSandwichMeatDTO meatDTO); 
    public List<MyOwnSandwichMeatDTO> findAllMeat();

    default MyOwnSandwichMeatDTO entityToDTO(MyOwnSandwichMeat meat, MyOwnSandwichMeatImg meatImg){
        MyOwnSandwichMeatDTO meatDTO = 
        MyOwnSandwichMeatDTO.builder().id(meat.getId())
                                        .name(meat.getName())
                                        .explanation(meat.getExplanation())
                                        .nutrition_info(meat.getNutrition_info())
                                        .one_serving(meat.getOne_serving())
                                        .regDate(meat.getRegDate())
                                        .modDate(meat.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(meatImg.getImgName())
                                            .path(meatImg.getPath())
                                            .uuid(meatImg.getUuid()).build())
                                        .build();
        return meatDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSandwichMeatDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSandwichMeat meat = MyOwnSandwichMeat.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("meat", meat);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSandwichMeatImg meatImg = MyOwnSandwichMeatImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSandwichMeat(meat)
                                            .build();
        entityMap.put("meatImg",meatImg);

        return entityMap;
    }
}
