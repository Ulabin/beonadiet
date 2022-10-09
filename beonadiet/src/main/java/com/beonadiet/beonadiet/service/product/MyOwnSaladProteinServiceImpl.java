package com.beonadiet.beonadiet.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.product.MyOwnSaladProteinDTO;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladProtein;
import com.beonadiet.beonadiet.entity.product.MyOwnSaladProteinImg;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladProteinImgRepository;
import com.beonadiet.beonadiet.repository.product.MyOwnSaladProteinRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnSaladProteinServiceImpl implements MyOwnSaladProteinService{
    private final MyOwnSaladProteinImgRepository proteinImgRepo;
    private final MyOwnSaladProteinRepository proteinRepo;

    @Override
    public void register(MyOwnSaladProteinDTO proteinDTO){
        MyOwnSaladProteinImg proteinImg = (MyOwnSaladProteinImg)(dtoToEntity(proteinDTO).get("proteinImg"));
        proteinRepo.save(proteinImg.getMyOwnSaladProtein());
        proteinImgRepo.save(proteinImg);
    }

    @Override
    public List<MyOwnSaladProteinDTO> findAllProtein() {
        List<MyOwnSaladProteinDTO> proteinDtoList = new ArrayList<>();
        List<MyOwnSaladProtein> proteinList = proteinRepo.findAll();
        proteinList.forEach(new Consumer<MyOwnSaladProtein>() {
            @Override
            public void accept(MyOwnSaladProtein t) {
                proteinDtoList.add(entityToDTO(t,proteinImgRepo.findByMyOwnSaladProtein(t)));
            }
        });

        return proteinDtoList;
    }
}
