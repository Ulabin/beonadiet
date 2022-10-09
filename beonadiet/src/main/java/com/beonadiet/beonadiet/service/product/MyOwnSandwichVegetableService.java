package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSandwichVegetableDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichVegetable;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichVegetableImg;

public interface MyOwnSandwichVegetableService {
    public void register(MyOwnSandwichVegetableDTO vegetableDTO); 
    public List<MyOwnSandwichVegetableDTO> findAllVegetable();

    default MyOwnSandwichVegetableDTO entityToDTO(MyOwnSandwichVegetable vegetable, MyOwnSandwichVegetableImg vegetableImg){
        MyOwnSandwichVegetableDTO vegetableDTO = 
        MyOwnSandwichVegetableDTO.builder().id(vegetable.getId())
                                        .name(vegetable.getName())
                                        .explanation(vegetable.getExplanation())
                                        .nutrition_info(vegetable.getNutrition_info())
                                        .one_serving(vegetable.getOne_serving())
                                        .regDate(vegetable.getRegDate())
                                        .modDate(vegetable.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(vegetableImg.getImgName())
                                            .path(vegetableImg.getPath())
                                            .uuid(vegetableImg.getUuid()).build())
                                        .build();
        return vegetableDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSandwichVegetableDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSandwichVegetable vegetable = MyOwnSandwichVegetable.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("vegetable", vegetable);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSandwichVegetableImg vegetableImg = MyOwnSandwichVegetableImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSandwichVegetable(vegetable)
                                            .build();
        entityMap.put("vegetableImg",vegetableImg);

        return entityMap;
    }
}
