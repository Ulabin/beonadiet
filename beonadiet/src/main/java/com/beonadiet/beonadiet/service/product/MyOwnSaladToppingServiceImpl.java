package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSaladToppingDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladTopping;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladToppingImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladToppingImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladToppingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSaladToppingServiceImpl implements MyOwnSaladToppingService{
    private final MyOwnSaladToppingImgRepository toppingImgRepo;
    private final MyOwnSaladToppingRepository toppingRepo;

    @Override
    public void register(MyOwnSaladToppingDTO toppingDTO){
        MyOwnSaladToppingImg toppingImg = (MyOwnSaladToppingImg)(dtoToEntity(toppingDTO).get("toppingImg"));
        toppingRepo.save(toppingImg.getMyOwnSaladTopping());
        toppingImgRepo.save(toppingImg);
    }

    @Override
    public List<MyOwnSaladToppingDTO> findAllTopping() {
        List<MyOwnSaladToppingDTO> toppingDtoList = new ArrayList<>();
        List<MyOwnSaladTopping> toppingList = toppingRepo.findAll();
        toppingList.forEach(new Consumer<MyOwnSaladTopping>() {
            @Override
            public void accept(MyOwnSaladTopping t) {
                toppingDtoList.add(entityToDTO(t,toppingImgRepo.findByMyOwnSaladTopping(t)));
            }
        });

        return toppingDtoList;
    }
}
