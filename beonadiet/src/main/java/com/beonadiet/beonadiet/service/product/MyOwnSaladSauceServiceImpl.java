package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSaladSauceDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladSauce;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladSauceImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladSauceImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladSauceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSaladSauceServiceImpl implements MyOwnSaladSauceService{
    private final MyOwnSaladSauceImgRepository sauceImgRepo;
    private final MyOwnSaladSauceRepository sauceRepo;

    @Override
    public void register(MyOwnSaladSauceDTO sauceDTO){
        MyOwnSaladSauceImg sauceImg = (MyOwnSaladSauceImg)(dtoToEntity(sauceDTO).get("sauceImg"));
        sauceRepo.save(sauceImg.getMyOwnSaladSauce());
        sauceImgRepo.save(sauceImg);
    }

    @Override
    public List<MyOwnSaladSauceDTO> findAllSauce() {
        List<MyOwnSaladSauceDTO> sauceDtoList = new ArrayList<>();
        List<MyOwnSaladSauce> sauceList = sauceRepo.findAll();
        sauceList.forEach(new Consumer<MyOwnSaladSauce>() {
            @Override
            public void accept(MyOwnSaladSauce t) {
                sauceDtoList.add(entityToDTO(t,sauceImgRepo.findByMyOwnSaladSauce(t)));
            }
        });

        return sauceDtoList;
    }
}
