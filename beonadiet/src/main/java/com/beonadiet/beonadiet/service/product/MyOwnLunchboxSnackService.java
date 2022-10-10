package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSnackDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSnack;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSnackImg;

public interface MyOwnLunchboxSnackService {
    public void register(MyOwnLunchboxSnackDTO snackDTO); 
    public List<MyOwnLunchboxSnackDTO> findAllSnack();

    default MyOwnLunchboxSnackDTO entityToDTO(MyOwnLunchboxSnack snack, MyOwnLunchboxSnackImg snackImg){
        MyOwnLunchboxSnackDTO lunchboxSnackDTO = 
        MyOwnLunchboxSnackDTO.builder().id(snack.getId())
                                        .name(snack.getName())
                                        .explanation(snack.getExplanation())
                                        .nutrition_info(snack.getNutrition_info())
                                        .one_serving(snack.getOne_serving())
                                        .sales_count(snack.getSalescount())
                                        .regDate(snack.getRegDate())
                                        .modDate(snack.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(snackImg.getImgName())
                                            .path(snackImg.getPath())
                                            .uuid(snackImg.getUuid()).build())
                                        .build();
        return lunchboxSnackDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnLunchboxSnackDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnLunchboxSnack snack = MyOwnLunchboxSnack.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .salescount(dto.getSales_count())
                                    .build();
        entityMap.put("snack", snack);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnLunchboxSnackImg snackImg = MyOwnLunchboxSnackImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnLunchboxSnack(snack)
                                            .build();
        entityMap.put("snackImg",snackImg);

        return entityMap;
    }
}
