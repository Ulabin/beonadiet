package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxMinisaladDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxMinisalad;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxMinisaladImg;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxMinisaladImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxMinisaladRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnLunchboxMinisaladServiceImpl implements MyOwnLunchboxMinisaladService{
    private final MyOwnLunchboxMinisaladImgRepository minisaladImgRepo;
    private final MyOwnLunchboxMinisaladRepository minisaladRepo;

    @Override
    public void register(MyOwnLunchboxMinisaladDTO minisaladDTO){
        MyOwnLunchboxMinisaladImg minisaladImg = (MyOwnLunchboxMinisaladImg)(dtoToEntity(minisaladDTO).get("minisaladImg"));
        minisaladRepo.save(minisaladImg.getMyOwnLunchboxMinisalad());
        minisaladImgRepo.save(minisaladImg);
    }

    @Override
    public List<MyOwnLunchboxMinisaladDTO> findAllMinisalad() {
        List<MyOwnLunchboxMinisaladDTO> minisaladDtoList = new ArrayList<>();
        List<MyOwnLunchboxMinisalad> minisaladList = minisaladRepo.findAll();
        minisaladList.forEach(new Consumer<MyOwnLunchboxMinisalad>() {
            @Override
            public void accept(MyOwnLunchboxMinisalad t) {
                minisaladDtoList.add(entityToDTO(t,minisaladImgRepo.findByMyOwnLunchboxMinisalad(t)));
            }
        });

        return minisaladDtoList;
    }
}
