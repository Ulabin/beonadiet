package com.beonadiet.beonadiet.dto;

import java.time.LocalDateTime;

import com.beonadiet.beonadiet.dto.product.MyOwnElementImgDTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private Long id;
    private String content;
    private Float score;
    private Long like;
    private Long mid;
    private Long pid;
    private MyOwnElementImgDTO imageDTO;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
