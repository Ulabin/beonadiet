package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSoupDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSoup;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSoupImage;

public interface MyOwnLunchboxSoupService {
    public void register(MyOwnLunchboxSoupDTO soupDTO); 
    public List<MyOwnLunchboxSoupDTO> findAllSoup();

    default MyOwnLunchboxSoupDTO entityToDTO(MyOwnLunchboxSoup soup, MyOwnLunchboxSoupImage soupImg){
        MyOwnLunchboxSoupDTO lunchboxSoupDTO = 
        MyOwnLunchboxSoupDTO.builder().id(soup.getId())
                                        .name(soup.getName())
                                        .explanation(soup.getExplanation())
                                        .nutrition_info(soup.getNutrition_info())
                                        .one_serving(soup.getOne_serving())
                                        .sales_count(soup.getSales_count())
                                        .regDate(soup.getRegDate())
                                        .modDate(soup.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(soupImg.getImgName())
                                            .path(soupImg.getPath())
                                            .uuid(soupImg.getUuid()).build())
                                        .build();
        return lunchboxSoupDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnLunchboxSoupDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnLunchboxSoup soup = MyOwnLunchboxSoup.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .sales_count(dto.getSales_count())
                                    .build();
        entityMap.put("soup", soup);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnLunchboxSoupImage soupImg = MyOwnLunchboxSoupImage.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnLunchboxSoup(soup)
                                            .build();
        entityMap.put("soupImg",soupImg);

        return entityMap;
    }
}
