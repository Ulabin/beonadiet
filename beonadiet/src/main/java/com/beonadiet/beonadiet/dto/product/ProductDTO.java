package com.beonadiet.beonadiet.dto.product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private Long price;
    private String unit;
    private String materialAndContent;
    private String allergy;
    private String nutritionInfo;
    private String volume;
    private String caution;
    private String foodType;
    private String expirationDate;
    private String packageMaterial;
    private Long calorie;
    private String storageMethod;
    private String category;
    private String shippingMethod;
    private String bowl;

    private int reviewCount;
    private double avg;

    @Builder.Default
    private List<ProductImageDTO> imageDTOList = new ArrayList<>();

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
