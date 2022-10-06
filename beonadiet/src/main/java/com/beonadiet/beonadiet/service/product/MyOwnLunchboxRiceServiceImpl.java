package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxRiceDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxRice;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxRiceImage;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxRiceImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxRiceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnLunchboxRiceServiceImpl implements MyOwnLunchboxRiceService{
    private final MyOwnLunchboxRiceImgRepository riceImgRepo;
    private final MyOwnLunchboxRiceRepository riceRepo;

    @Override
    public void register(MyOwnLunchboxRiceDTO riceDTO){
        //log.info(dtoToEntity(riceDTO).get("rice"));
        MyOwnLunchboxRiceImage riceImg = (MyOwnLunchboxRiceImage)(dtoToEntity(riceDTO).get("riceImg"));
        riceRepo.save(riceImg.getMyOwnLunchboxRice());
        riceImgRepo.save(riceImg);
    }

    @Override
    public List<MyOwnLunchboxRiceDTO> findAllRice() {
        List<MyOwnLunchboxRiceDTO> riceDtoList = new ArrayList<>();
        List<MyOwnLunchboxRice> riceList = riceRepo.findAll();
        riceList.forEach(new Consumer<MyOwnLunchboxRice>() {
            @Override
            public void accept(MyOwnLunchboxRice t) {
                riceDtoList.add(entityToDTO(t,riceImgRepo.findByMyOwnLunchboxRice(t)));
            }
        });

        return riceDtoList;
    }
}
