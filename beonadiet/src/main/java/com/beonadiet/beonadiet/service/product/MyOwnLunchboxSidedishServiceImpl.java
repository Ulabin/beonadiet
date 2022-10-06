package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSidedishDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSidedish;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSidedishImage;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxSidedishImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxSidedishRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnLunchboxSidedishServiceImpl implements MyOwnLunchboxSidedishService{
    private final MyOwnLunchboxSidedishImgRepository sidedishImgRepo;
    private final MyOwnLunchboxSidedishRepository sidedishRepo;

    @Override
    public void register(MyOwnLunchboxSidedishDTO sidedishDTO){
        MyOwnLunchboxSidedishImage sidedishImg = (MyOwnLunchboxSidedishImage)(dtoToEntity(sidedishDTO).get("sidedishImg"));
        sidedishRepo.save(sidedishImg.getMyOwnLunchboxSidedish());
        sidedishImgRepo.save(sidedishImg);
    }

    @Override
    public List<MyOwnLunchboxSidedishDTO> findAllSidedish() {
        List<MyOwnLunchboxSidedishDTO> sidedishDtoList = new ArrayList<>();
        List<MyOwnLunchboxSidedish> sidedishList = sidedishRepo.findAll();
        sidedishList.forEach(new Consumer<MyOwnLunchboxSidedish>() {
            @Override
            public void accept(MyOwnLunchboxSidedish t) {
                sidedishDtoList.add(entityToDTO(t,sidedishImgRepo.findByMyOwnLunchboxSidedish(t)));
            }
        });

        return sidedishDtoList;
    }
}
