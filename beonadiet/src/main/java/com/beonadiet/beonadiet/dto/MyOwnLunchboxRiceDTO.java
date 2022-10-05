package com.beonadiet.beonadiet.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyOwnLunchboxRiceDTO {
    private Long id;
    private String name;
    private String explanation;
    private String nutrition_info;
    private String one_serving;
    private MyOwnLunchboxRiceImgDTO imageDTO;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
