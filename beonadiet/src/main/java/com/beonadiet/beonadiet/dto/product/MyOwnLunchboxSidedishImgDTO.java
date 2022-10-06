package com.beonadiet.beonadiet.dto.product;

import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyOwnLunchboxSidedishImgDTO {
    private String uuid;
    private String imgName;
    private String path;

    public String getImageURL(){
        try {
          return URLEncoder.encode(uuid+"_"+imgName, "UTF-8");
        } catch (Exception e) {e.printStackTrace();}
        return "";
    }
}
