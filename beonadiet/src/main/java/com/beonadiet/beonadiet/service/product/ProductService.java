package com.beonadiet.beonadiet.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.beonadiet.beonadiet.dto.product.ProductDTO;
import com.beonadiet.beonadiet.dto.product.ProductImageDTO;
import com.beonadiet.beonadiet.entity.product.Product;
import com.beonadiet.beonadiet.entity.product.ProductImage;

public interface ProductService {
    public void register(ProductDTO productDTO);
    //public List<ProductDTO> findAllProduct();

    public ProductDTO findByName(String name);
    public Product findById(Long id);

    default ProductDTO entityToDTO(Product product, List<ProductImage> pi,double avg,int reviewCount){
        ProductDTO productDTO = ProductDTO.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .unit(product.getUnit())
        .materialAndContent(product.getMaterialAndContent())
        .allergy(product.getAllergy())
        .volume(product.getVolume())
        .nutritionInfo(product.getNutritionInfo())
        .caution(product.getCaution())
        .foodType(product.getFoodType())
        .expirationDate(product.getExpirationDate())
        .packageMaterial(product.getPackageMaterial())
        .calorie(product.getCalorie())
        .storageMethod(product.getStorageMethod())
        .category(product.getCategory())
        .shippingMethod(product.getShippingMethod())
        .bowl(product.getBowl())
        .build();

        List<ProductImageDTO> productImageDTOs = pi.stream().map(
            new Function<ProductImage, ProductImageDTO>(){
                public ProductImageDTO apply(ProductImage p){
                    return ProductImageDTO.builder()
                    .imgName(p.getImgName()).folderPath(p.getFolderPath()).path(p.getPath()).uuid(p.getUuid()).build();
                };
            }).collect(Collectors.toList());

        productDTO.setImageDTOList(productImageDTOs);
        productDTO.setAvg(avg);
        productDTO.setReviewCount(reviewCount);

        return productDTO;
    }

    default Map<String, Object> dtoToEntity(ProductDTO dto){
        Map<String, Object> entityMap = new HashMap<>();
    
        Product product = Product.builder()
        .id(dto.getId())
        .name(dto.getName())
        .price(dto.getPrice())
        .unit(dto.getUnit())
        .materialAndContent(dto.getMaterialAndContent())
        .allergy(dto.getAllergy())
        .nutritionInfo(dto.getNutritionInfo())
        .volume(dto.getVolume())
        .caution(dto.getCaution())
        .foodType(dto.getFoodType())
        .expirationDate(dto.getExpirationDate())
        .packageMaterial(dto.getPackageMaterial())
        .calorie(dto.getCalorie())
        .storageMethod(dto.getStorageMethod())
        .category(dto.getCategory())
        .shippingMethod(dto.getShippingMethod())
        .bowl(dto.getBowl())
        .build();
        entityMap.put("product", product); 
        
        List<ProductImageDTO> imageDTOList = dto.getImageDTOList();
        
        if(imageDTOList != null && imageDTOList.size() > 0) {
          List<ProductImage> productImageList = imageDTOList.stream().map(
            new Function<ProductImageDTO,ProductImage>() {
              @Override
              public ProductImage apply(ProductImageDTO t) {
                ProductImage productImage = ProductImage.builder().path(t.getPath()).folderPath(t.getFolderPath())
                                        .imgName(t.getImgName()).uuid(t.getUuid())
                                        .product(product).build();
                return productImage;
              }
            }
          ).collect(Collectors.toList());
          entityMap.put("imgList", productImageList);
        }
        return entityMap;
      }
}
