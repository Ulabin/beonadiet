package com.beonadiet.beonadiet.service.product;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beonadiet.beonadiet.dto.product.ProductDTO;
import com.beonadiet.beonadiet.entity.product.Product;
import com.beonadiet.beonadiet.entity.product.ProductImage;
import com.beonadiet.beonadiet.repository.product.ProductImageRepository;
import com.beonadiet.beonadiet.repository.product.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductImageRepository piRepository;
    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void register(ProductDTO dto) {
      Map<String, Object> entityMap = dtoToEntity(dto);
  
      Product product = (Product) entityMap.get("product");
      List<ProductImage> productImageList = (List<ProductImage>) entityMap.get("imgList");
  
      productRepository.save(product);
      productImageList.forEach(new Consumer<ProductImage>() {
        @Override
        public void accept(ProductImage productImage) {
          piRepository.save(productImage);
        }
      });
    }

    @Override
    public ProductDTO findByName(String name) {
        List<Product> productList = productRepository.findByName(name);
        Product product = productList.get(0);
        List<ProductImage> productImageList = piRepository.findByProduct(product);
        ProductDTO productDTO = entityToDTO(product,productImageList,0,0);
        return productDTO;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product=productRepository.findById(id);
        if(product.isPresent()){
          return product.get();
        }
        return null;
    }
}
