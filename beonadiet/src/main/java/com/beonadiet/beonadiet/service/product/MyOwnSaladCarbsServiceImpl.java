package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSaladCarbsDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladCarbs;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladCarbsImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladCarbsImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladCarbsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSaladCarbsServiceImpl implements MyOwnSaladCarbsService{
    private final MyOwnSaladCarbsImgRepository carbsImgRepo;
    private final MyOwnSaladCarbsRepository carbsRepo;

    @Override
    public void register(MyOwnSaladCarbsDTO carbsDTO){
        MyOwnSaladCarbsImg carbsImg = (MyOwnSaladCarbsImg)(dtoToEntity(carbsDTO).get("carbsImg"));
        carbsRepo.save(carbsImg.getMyOwnSaladCarbs());
        carbsImgRepo.save(carbsImg);
    }

    @Override
    public List<MyOwnSaladCarbsDTO> findAllCarbs() {
        List<MyOwnSaladCarbsDTO> carbsDtoList = new ArrayList<>();
        List<MyOwnSaladCarbs> carbsList = carbsRepo.findAll();
        carbsList.forEach(new Consumer<MyOwnSaladCarbs>() {
            @Override
            public void accept(MyOwnSaladCarbs t) {
                carbsDtoList.add(entityToDTO(t,carbsImgRepo.findByMyOwnSaladCarbs(t)));
            }
        });

        return carbsDtoList;
    }
}
