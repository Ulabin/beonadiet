package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSandwichCheeseDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichCheese;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichCheeseImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichCheeseImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichCheeseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSandwichCheeseServiceImpl implements MyOwnSandwichCheeseService{
    private final MyOwnSandwichCheeseImgRepository cheeseImgRepo;
    private final MyOwnSandwichCheeseRepository cheeseRepo;

    @Override
    public void register(MyOwnSandwichCheeseDTO cheeseDTO){
        MyOwnSandwichCheeseImg cheeseImg = (MyOwnSandwichCheeseImg)(dtoToEntity(cheeseDTO).get("cheeseImg"));
        cheeseRepo.save(cheeseImg.getMyOwnSandwichCheese());
        cheeseImgRepo.save(cheeseImg);
    }

    @Override
    public List<MyOwnSandwichCheeseDTO> findAllCheese() {
        List<MyOwnSandwichCheeseDTO> cheeseDtoList = new ArrayList<>();
        List<MyOwnSandwichCheese> cheeseList = cheeseRepo.findAll();
        cheeseList.forEach(new Consumer<MyOwnSandwichCheese>() {
            @Override
            public void accept(MyOwnSandwichCheese t) {
                cheeseDtoList.add(entityToDTO(t,cheeseImgRepo.findByMyOwnSandwichCheese(t)));
            }
        });

        return cheeseDtoList;
    }
}
