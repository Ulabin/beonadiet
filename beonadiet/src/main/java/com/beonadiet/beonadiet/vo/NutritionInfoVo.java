package com.beonadiet.beonadiet.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NutritionInfoVo {
    private Float weight;
    private Float kcal;
    private Float carbs;
    private Float protein;
    private Float fat;
    private Float saturated_fat;
    private Float cholesterol;
    private Float salt;
}
