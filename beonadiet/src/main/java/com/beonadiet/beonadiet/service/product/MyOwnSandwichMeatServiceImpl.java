package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSandwichMeatDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichMeat;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichMeatImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichMeatImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichMeatRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSandwichMeatServiceImpl implements MyOwnSandwichMeatService{
    private final MyOwnSandwichMeatImgRepository meatImgRepo;
    private final MyOwnSandwichMeatRepository meatRepo;

    @Override
    public void register(MyOwnSandwichMeatDTO meatDTO){
        MyOwnSandwichMeatImg meatImg = (MyOwnSandwichMeatImg)(dtoToEntity(meatDTO).get("meatImg"));
        meatRepo.save(meatImg.getMyOwnSandwichMeat());
        meatImgRepo.save(meatImg);
    }

    @Override
    public List<MyOwnSandwichMeatDTO> findAllMeat() {
        List<MyOwnSandwichMeatDTO> meatDtoList = new ArrayList<>();
        List<MyOwnSandwichMeat> meatList = meatRepo.findAll();
        meatList.forEach(new Consumer<MyOwnSandwichMeat>() {
            @Override
            public void accept(MyOwnSandwichMeat t) {
                meatDtoList.add(entityToDTO(t,meatImgRepo.findByMyOwnSandwichMeat(t)));
            }
        });

        return meatDtoList;
    }
}
