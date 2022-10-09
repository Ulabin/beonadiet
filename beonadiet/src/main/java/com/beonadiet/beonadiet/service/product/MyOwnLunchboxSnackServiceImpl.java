package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnLunchboxSnackDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSnack;
import com.beonadiet.beonadiet.entity.product.MyOwnLunchboxSnackImg;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxSnackImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnLunchboxSnackRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnLunchboxSnackServiceImpl implements MyOwnLunchboxSnackService{
    private final MyOwnLunchboxSnackImgRepository snackImgRepo;
    private final MyOwnLunchboxSnackRepository snackRepo;

    @Override
    public void register(MyOwnLunchboxSnackDTO snackDTO){
        MyOwnLunchboxSnackImg saladImg = (MyOwnLunchboxSnackImg)(dtoToEntity(snackDTO).get("snackImg"));
        snackRepo.save(saladImg.getMyOwnLunchboxSnack());
        snackImgRepo.save(saladImg);
    }

    @Override
    public List<MyOwnLunchboxSnackDTO> findAllSnack() {
        List<MyOwnLunchboxSnackDTO> snackDtoList = new ArrayList<>();
        List<MyOwnLunchboxSnack> snackList = snackRepo.findAll();
        snackList.forEach(new Consumer<MyOwnLunchboxSnack>() {
            @Override
            public void accept(MyOwnLunchboxSnack t) {
                snackDtoList.add(entityToDTO(t,snackImgRepo.findByMyOwnLunchboxSnack(t)));
            }
        });

        return snackDtoList;
    }
}
