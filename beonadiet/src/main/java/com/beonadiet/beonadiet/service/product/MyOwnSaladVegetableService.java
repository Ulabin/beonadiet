package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladVegetableDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladVegetable;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladVegetableImg;

public interface MyOwnSaladVegetableService {
    public void register(MyOwnSaladVegetableDTO vegetableDTO); 
    public List<MyOwnSaladVegetableDTO> findAllVegetable();

    default MyOwnSaladVegetableDTO entityToDTO(MyOwnSaladVegetable vegetable, MyOwnSaladVegetableImg vegetableImg){
        MyOwnSaladVegetableDTO vegetableDTO = 
        MyOwnSaladVegetableDTO.builder().id(vegetable.getId())
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

    default Map<String, Object> dtoToEntity(MyOwnSaladVegetableDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSaladVegetable vegetable = MyOwnSaladVegetable.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("vegetable", vegetable);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSaladVegetableImg vegetableImg = MyOwnSaladVegetableImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSaladVegetable(vegetable)
                                            .build();
        entityMap.put("vegetableImg",vegetableImg);

        return entityMap;
    }
}
