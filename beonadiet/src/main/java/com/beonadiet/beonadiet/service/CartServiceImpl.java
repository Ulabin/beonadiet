package com.beonadiet.beonadiet.service;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.CartDto;
import com.beonadiet.beonadiet.entity.Cart;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.CartRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartServiceImpl implements CartService {
    private final CartRepository repository;

    @Override
    public List<CartDto> findByMember(Member member) {
        List<CartDto> cartDtoList = new ArrayList<>();
        List<Cart> cartList = repository.findByMember(member);
        cartList.forEach(new Consumer<Cart>() {
            @Override
            public void accept(Cart t) {
                cartDtoList.add(entityToDTO(t));
            }
        });

        return cartDtoList;
    }

    @Override
    public void register(CartDto cartDTO) {
        repository.save(dtoToEntity(cartDTO));
    }
}
