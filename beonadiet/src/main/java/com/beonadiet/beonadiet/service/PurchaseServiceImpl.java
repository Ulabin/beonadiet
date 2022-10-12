package com.beonadiet.beonadiet.service;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.dto.PurchaseDTO;
import com.beonadiet.beonadiet.entity.Purchase;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.PurchaseRepository;
import com.beonadiet.beonadiet.repository.PurchaseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository repository;

    @Override
    public List<PurchaseDTO> findByMember(Member member) {
        List<PurchaseDTO> purchaseDtoList = new ArrayList<>();
        List<Purchase> purchaseList = repository.findByMember(member);
        purchaseList.forEach(new Consumer<Purchase>() {
            @Override
            public void accept(Purchase t) {
                purchaseDtoList.add(entityToDTO(t));
            }
        });

        return purchaseDtoList;
    }

    @Override
    public void register(PurchaseDTO cartDTO) {
        repository.save(dtoToEntity(cartDTO));
    }
}
