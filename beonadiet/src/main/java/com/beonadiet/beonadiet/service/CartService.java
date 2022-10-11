package com.beonadiet.beonadiet.service;

import java.util.List;

import com.beonadiet.beonadiet.dto.CartDto;
import com.beonadiet.beonadiet.entity.Cart;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.entity.product.Product;

public interface CartService {
    public void register(CartDto cartDTO); 
    public List<CartDto> findByMember(Member member);

    default CartDto entityToDTO(Cart cart){
        CartDto cartDTO = 
        CartDto.builder().id(cart.getId())
                        .combination_content(cart.getCombination_content())
                        .carbs_amount(cart.getCarbs_amount())
                        .protein_amount(cart.getProtein_amount())
                        .fat_amount(cart.getFat_amount())
                        .calorie(cart.getCalorie())
                        .mid(cart.getMember().getId())
                        .pid(cart.getProduct().getId())
                        .productCount(cart.getProductCount())
                        .regDate(cart.getRegDate())
                        .modDate(cart.getModDate())
                        .build();
                            
        return cartDTO;
    }

    default Cart dtoToEntity(CartDto dto){
        Cart cart = Cart.builder()
                        .id(dto.getId())
                        .combination_content(dto.getCombination_content())
                        .carbs_amount(dto.getCarbs_amount())
                        .protein_amount(dto.getProtein_amount())
                        .fat_amount(dto.getFat_amount())
                        .calorie(dto.getCalorie())
                        .member(Member.builder().id(dto.getMid()).build())
                        .product(Product.builder().id(dto.getPid()).build())
                        .productCount(dto.getProductCount())
                        .build();

        return cart;
    }
}
