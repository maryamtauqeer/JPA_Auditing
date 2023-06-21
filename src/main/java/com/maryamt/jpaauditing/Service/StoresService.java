package com.maryamt.jpaauditing.Service;


import com.maryamt.jpaauditing.DTO.StoresDTO;
import com.maryamt.jpaauditing.Entity.Items;
import com.maryamt.jpaauditing.Entity.Stores;
import com.maryamt.jpaauditing.Entity.StoresResponse;
import com.maryamt.jpaauditing.Exception.EntityNotFoundException;
import com.maryamt.jpaauditing.Repository.StoresRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StoresService {
    @Autowired
    StoresRepository storesRepository;

    public StoresResponse createStore(final StoresDTO dto) {
        log.info("Creating new store");

        Stores store = Stores.builder()
                .storesName(dto.getStoresName())
                .items(dto.getItems())
                .build();
        storesRepository.save(store);
        for (Items items : store.getItems()) {
            System.out.println("CHECKKK"+store);
            items.setStore_id(store);
//            System.out.println("CHECKKK 2"+items.getStore_id());// Set the store for each product
        }
        return StoresResponse.from(store);
    }

    public List<StoresResponse> getAll() {
        log.info("Getting all stores");
        return storesRepository.findAll()
                .stream()
                .map(StoresResponse::from)
                .collect(Collectors.toList());
    }

    public Stores getStores(final int id) throws EntityNotFoundException {
        log.info("Getting stores id = {}", id);
        return storesRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Store %s not found", id)));
    }

    public void updateStores(final int id, final StoresDTO dto) throws EntityNotFoundException {
        log.info("Updating store id = {}", id);
        getStores(id);
        Stores s = Stores.builder()
                .id(id)
                .storesName(dto.getStoresName())
                .items(dto.getItems())
                .build();
        storesRepository.save(s);
    }
}
