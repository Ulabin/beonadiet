package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSoupDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSoup;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSoupImage;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxSoupImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxSoupRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnLunchboxSoupServiceImpl implements MyOwnLunchboxSoupService{
    private final MyOwnLunchboxSoupImgRepository soupImgRepo;
    private final MyOwnLunchboxSoupRepository soupRepo;

    @Override
    public void register(MyOwnLunchboxSoupDTO soupDTO){
        MyOwnLunchboxSoupImage soupImg = (MyOwnLunchboxSoupImage)(dtoToEntity(soupDTO).get("soupImg"));
        soupRepo.save(soupImg.getMyOwnLunchboxSoup());
        soupImgRepo.save(soupImg);
    }

    @Override
    public List<MyOwnLunchboxSoupDTO> findAllSoup() {
        List<MyOwnLunchboxSoupDTO> soupDtoList = new ArrayList<>();
        List<MyOwnLunchboxSoup> soupList = soupRepo.findAll();
        soupList.forEach(new Consumer<MyOwnLunchboxSoup>() {
            @Override
            public void accept(MyOwnLunchboxSoup t) {
                soupDtoList.add(entityToDTO(t,soupImgRepo.findByMyOwnLunchboxSoup(t)));
            }
        });

        return soupDtoList;
    }
}
