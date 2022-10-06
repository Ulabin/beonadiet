package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceImgDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxRice;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxRiceImage;

public interface MyOwnLunchboxRiceService {
    public void register(MyOwnLunchboxRiceDTO riceDTO); 
    public List<MyOwnLunchboxRiceDTO> findAllRice();

    default MyOwnLunchboxRiceDTO entityToDTO(MyOwnLunchboxRice rice, MyOwnLunchboxRiceImage riceImg){
        MyOwnLunchboxRiceDTO lunchboxRiceDTO = 
        MyOwnLunchboxRiceDTO.builder().id(rice.getId())
                                        .name(rice.getName())
                                        .explanation(rice.getExplanation())
                                        .nutrition_info(rice.getNutrition_info())
                                        .one_serving(rice.getOne_serving())
                                        .regDate(rice.getRegDate())
                                        .modDate(rice.getModDate())
                                        .imageDTO(MyOwnLunchboxRiceImgDTO.builder()
                                            .imgName(riceImg.getImgName())
                                            .path(riceImg.getPath())
                                            .uuid(riceImg.getUuid()).build())
                                        .build();
        return lunchboxRiceDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnLunchboxRiceDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnLunchboxRice rice = MyOwnLunchboxRice.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .build();
        entityMap.put("rice", rice);
        
        MyOwnLunchboxRiceImgDTO imgDTO = dto.getImageDTO();
        MyOwnLunchboxRiceImage riceImg = MyOwnLunchboxRiceImage.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnLunchboxRice(rice)
                                            .build();
        entityMap.put("riceImg",riceImg);

        return entityMap;
    }
}
