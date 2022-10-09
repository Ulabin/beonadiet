package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSandwichToppingDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichTopping;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichToppingImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichToppingImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichToppingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSandwichToppingServiceImpl implements MyOwnSandwichToppingService{
    private final MyOwnSandwichToppingImgRepository toppingImgRepo;
    private final MyOwnSandwichToppingRepository toppingRepo;

    @Override
    public void register(MyOwnSandwichToppingDTO toppingDTO){
        MyOwnSandwichToppingImg toppingImg = (MyOwnSandwichToppingImg)(dtoToEntity(toppingDTO).get("toppingImg"));
        toppingRepo.save(toppingImg.getMyOwnSandwichTopping());
        toppingImgRepo.save(toppingImg);
    }

    @Override
    public List<MyOwnSandwichToppingDTO> findAllTopping() {
        List<MyOwnSandwichToppingDTO> toppingDtoList = new ArrayList<>();
        List<MyOwnSandwichTopping> toppingList = toppingRepo.findAll();
        toppingList.forEach(new Consumer<MyOwnSandwichTopping>() {
            @Override
            public void accept(MyOwnSandwichTopping t) {
                toppingDtoList.add(entityToDTO(t,toppingImgRepo.findByMyOwnSandwichTopping(t)));
            }
        });

        return toppingDtoList;
    }
}
