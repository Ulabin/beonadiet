package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSandwichVegetableDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichVegetable;
import com.beonadiet.beonadiet.entity.product.MyOwnSandwichVegetableImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichVegetableImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSandwichVegetableRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSandwichVegetableServiceImpl implements MyOwnSandwichVegetableService{
    private final MyOwnSandwichVegetableImgRepository vegetableImgRepo;
    private final MyOwnSandwichVegetableRepository vegetableRepo;

    @Override
    public void register(MyOwnSandwichVegetableDTO vegetableDTO){
        MyOwnSandwichVegetableImg vegetableImg = (MyOwnSandwichVegetableImg)(dtoToEntity(vegetableDTO).get("vegetableImg"));
        vegetableRepo.save(vegetableImg.getMyOwnSandwichVegetable());
        vegetableImgRepo.save(vegetableImg);
    }

    @Override
    public List<MyOwnSandwichVegetableDTO> findAllVegetable() {
        List<MyOwnSandwichVegetableDTO> vegetableDtoList = new ArrayList<>();
        List<MyOwnSandwichVegetable> vegetableList = vegetableRepo.findAll();
        vegetableList.forEach(new Consumer<MyOwnSandwichVegetable>() {
            @Override
            public void accept(MyOwnSandwichVegetable t) {
                vegetableDtoList.add(entityToDTO(t,vegetableImgRepo.findByMyOwnSandwichVegetable(t)));
            }
        });

        return vegetableDtoList;
    }
}
