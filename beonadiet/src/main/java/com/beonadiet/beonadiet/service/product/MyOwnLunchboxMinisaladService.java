package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxMinisaladDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxMinisalad;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxMinisaladImg;

public interface MyOwnLunchboxMinisaladService {
    public void register(MyOwnLunchboxMinisaladDTO minisaladDTO); 
    public List<MyOwnLunchboxMinisaladDTO> findAllMinisalad();

    default MyOwnLunchboxMinisaladDTO entityToDTO(MyOwnLunchboxMinisalad minisalad, MyOwnLunchboxMinisaladImg minisaladImg){
        MyOwnLunchboxMinisaladDTO lunchboxMinisaladDTO = 
        MyOwnLunchboxMinisaladDTO.builder().id(minisalad.getId())
                                        .name(minisalad.getName())
                                        .explanation(minisalad.getExplanation())
                                        .nutrition_info(minisalad.getNutrition_info())
                                        .one_serving(minisalad.getOne_serving())
                                        .sales_count(minisalad.getSales_count())
                                        .regDate(minisalad.getRegDate())
                                        .modDate(minisalad.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(minisaladImg.getImgName())
                                            .path(minisaladImg.getPath())
                                            .uuid(minisaladImg.getUuid()).build())
                                        .build();
        return lunchboxMinisaladDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnLunchboxMinisaladDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnLunchboxMinisalad minisalad = MyOwnLunchboxMinisalad.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .sales_count(dto.getSales_count())
                                    .build();
        entityMap.put("minisalad", minisalad);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnLunchboxMinisaladImg minisaladImg = MyOwnLunchboxMinisaladImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnLunchboxMinisalad(minisalad)
                                            .build();
        entityMap.put("minisaladImg",minisaladImg);

        return entityMap;
    }
}
