package com.beonadiet.beonadiet.dto.product;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyOwnSandwichMeatDTO {
    private Long id;
    private String name;
    private String explanation;
    private String nutrition_info;
    private String one_serving;
    private MyOwnElementImgDTO imageDTO;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
