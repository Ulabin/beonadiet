package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSandwichBreadDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichBread;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichBreadImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichBreadImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichBreadRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSandwichBreadServiceImpl implements MyOwnSandwichBreadService{
    private final MyOwnSandwichBreadImgRepository breadImgRepo;
    private final MyOwnSandwichBreadRepository breadRepo;

    @Override
    public void register(MyOwnSandwichBreadDTO breadDTO){
        MyOwnSandwichBreadImg breadImg = (MyOwnSandwichBreadImg)(dtoToEntity(breadDTO).get("breadImg"));
        breadRepo.save(breadImg.getMyOwnSandwichBread());
        breadImgRepo.save(breadImg);
    }

    @Override
    public List<MyOwnSandwichBreadDTO> findAllBread() {
        List<MyOwnSandwichBreadDTO> breadDtoList = new ArrayList<>();
        List<MyOwnSandwichBread> breadList = breadRepo.findAll();
        breadList.forEach(new Consumer<MyOwnSandwichBread>() {
            @Override
            public void accept(MyOwnSandwichBread t) {
                breadDtoList.add(entityToDTO(t,breadImgRepo.findByMyOwnSandwichBread(t)));
            }
        });

        return breadDtoList;
    }
}
