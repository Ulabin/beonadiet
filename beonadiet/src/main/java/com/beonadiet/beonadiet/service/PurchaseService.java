package com.beonadiet.beonadiet.service;

import java.util.List;

import com.beonadiet.beonadiet.dto.PurchaseDTO;
import com.beonadiet.beonadiet.entity.Purchase;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.entity.product.Product;

public interface PurchaseService {
    public void register(PurchaseDTO purchaseDTO); 
    public List<PurchaseDTO> findByMember(Member member);

    default PurchaseDTO entityToDTO(Purchase purchase){
        PurchaseDTO purchaseDTO = 
        PurchaseDTO.builder().id(purchase.getId())
                        .combination_content(purchase.getCombination_content())
                        .productCount(purchase.getProductCount())
                        .productPrice(purchase.getPrice())
                        .regDate(purchase.getRegDate())
                        .mid(purchase.getMember().getId())
                        .pid(purchase.getProduct().getId())
                        .build();
                            
        return purchaseDTO;
    }

    default Purchase dtoToEntity(PurchaseDTO dto){
        Purchase purchase = Purchase.builder()
                        .id(dto.getId())
                        .combination_content(dto.getCombination_content())
                        .member(Member.builder().id(dto.getMid()).build())
                        .product(Product.builder().id(dto.getPid()).build())
                        .productCount(dto.getProductCount())
                        .price(dto.getProductPrice())
                        .build();

        return purchase;
    }
}
