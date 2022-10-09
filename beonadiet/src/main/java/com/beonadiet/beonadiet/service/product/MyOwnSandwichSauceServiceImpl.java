package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSandwichSauceDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichSauce;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichSauceImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichSauceImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichSauceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSandwichSauceServiceImpl implements MyOwnSandwichSauceService{
    private final MyOwnSandwichSauceImgRepository sauceImgRepo;
    private final MyOwnSandwichSauceRepository sauceRepo;

    @Override
    public void register(MyOwnSandwichSauceDTO sauceDTO){
        MyOwnSandwichSauceImg SauceImg = (MyOwnSandwichSauceImg)(dtoToEntity(sauceDTO).get("sauceImg"));
        sauceRepo.save(SauceImg.getMyOwnSandwichSauce());
        sauceImgRepo.save(SauceImg);
    }

    @Override
    public List<MyOwnSandwichSauceDTO> findAllSauce() {
        List<MyOwnSandwichSauceDTO> sauceDtoList = new ArrayList<>();
        List<MyOwnSandwichSauce> sauceList = sauceRepo.findAll();
        sauceList.forEach(new Consumer<MyOwnSandwichSauce>() {
            @Override
            public void accept(MyOwnSandwichSauce t) {
                sauceDtoList.add(entityToDTO(t,sauceImgRepo.findByMyOwnSandwichSauce(t)));
            }
        });

        return sauceDtoList;
    }
}
