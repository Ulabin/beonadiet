package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSaladVegetableDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladVegetable;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladVegetableImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladVegetableImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladVegetableRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSaladVegetableServiceImpl implements MyOwnSaladVegetableService{
    private final MyOwnSaladVegetableImgRepository vegetableImgRepo;
    private final MyOwnSaladVegetableRepository vegetableRepo;

    @Override
    public void register(MyOwnSaladVegetableDTO vegetableDTO){
        MyOwnSaladVegetableImg vegetableImg = (MyOwnSaladVegetableImg)(dtoToEntity(vegetableDTO).get("vegetableImg"));
        vegetableRepo.save(vegetableImg.getMyOwnSaladVegetable());
        vegetableImgRepo.save(vegetableImg);
    }

    @Override
    public List<MyOwnSaladVegetableDTO> findAllVegetable() {
        List<MyOwnSaladVegetableDTO> vegetableDtoList = new ArrayList<>();
        List<MyOwnSaladVegetable> vegetableList = vegetableRepo.findAll();
        vegetableList.forEach(new Consumer<MyOwnSaladVegetable>() {
            @Override
            public void accept(MyOwnSaladVegetable t) {
                vegetableDtoList.add(entityToDTO(t,vegetableImgRepo.findByMyOwnSaladVegetable(t)));
            }
        });

        return vegetableDtoList;
    }
}
