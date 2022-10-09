package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;
import com.beonadiet.beonadiet.dto.product.MyOwnSaladProteinDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladProtein;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladProteinImg;

public interface MyOwnSaladProteinService {
    public void register(MyOwnSaladProteinDTO proteinDTO); 
    public List<MyOwnSaladProteinDTO> findAllProtein();

    default MyOwnSaladProteinDTO entityToDTO(MyOwnSaladProtein protein, MyOwnSaladProteinImg proteinImg){
        MyOwnSaladProteinDTO proteinDTO = 
        MyOwnSaladProteinDTO.builder().id(protein.getId())
                                        .name(protein.getName())
                                        .explanation(protein.getExplanation())
                                        .nutrition_info(protein.getNutrition_info())
                                        .one_serving(protein.getOne_serving())
                                        .category(protein.getCategory())
                                        .regDate(protein.getRegDate())
                                        .modDate(protein.getModDate())
                                        .imageDTO(MyOwnElementImgDTO.builder()
                                            .imgName(proteinImg.getImgName())
                                            .path(proteinImg.getPath())
                                            .uuid(proteinImg.getUuid()).build())
                                        .build();
        return proteinDTO;
    }

    default Map<String, Object> dtoToEntity(MyOwnSaladProteinDTO dto){
        Map<String, Object> entityMap = new HashMap<>(); 
        MyOwnSaladProtein protein = MyOwnSaladProtein.builder()
                                    .id(dto.getId())
                                    .name(dto.getName())
                                    .explanation(dto.getExplanation())
                                    .nutrition_info(dto.getNutrition_info())
                                    .one_serving(dto.getOne_serving())
                                    .category(dto.getCategory())
                                    .build();
        entityMap.put("protein", protein);
        
        MyOwnElementImgDTO imgDTO = dto.getImageDTO();
        MyOwnSaladProteinImg proteinImg = MyOwnSaladProteinImg.builder()
                                            .path(imgDTO.getPath())
                                            .imgName(imgDTO.getImgName())
                                            .uuid(imgDTO.getUuid())
                                            .myOwnSaladProtein(protein)
                                            .build();
        entityMap.put("proteinImg",proteinImg);

        return entityMap;
    }
}
