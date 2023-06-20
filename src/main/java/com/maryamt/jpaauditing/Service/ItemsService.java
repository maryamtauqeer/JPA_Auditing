package com.maryamt.jpaauditing.Service;

import com.maryamt.jpaauditing.DTO.ItemsDTO;
import com.maryamt.jpaauditing.Entity.Items;
import com.maryamt.jpaauditing.Entity.ItemsResponse;
import com.maryamt.jpaauditing.Exception.EntityNotFoundException;
import com.maryamt.jpaauditing.Repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ItemsService {

    @Autowired
    ItemsRepository repository;

//    public void saveAll(final List<Items> itemss) {
//        repository.saveAll(itemss);
//    }

    public ItemsResponse createItem(final ItemsDTO dto) {
        log.info("Creating new item");
        Items item = Items.builder()
                .itemsName(dto.getItemsName())
                .material(dto.getMaterial())
                .price(dto.getPrice())
                .promotionCode(dto.getPromotionCode())
                .build();
        repository.save(item);
        return ItemsResponse.from(item);
    }

    public List<ItemsResponse> getAll() {
        log.info("Getting all items");
        return repository.findAll()
                .stream()
                .map(ItemsResponse::from)
                .collect(Collectors.toList());
    }

    public Items getItems(final int id) throws EntityNotFoundException {
        log.info("Getting items id = {}", id);
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Items %s not found", id)));
    }

    public void updateItems(final int id, final ItemsDTO dto) throws EntityNotFoundException {
        log.info("Updating items id = {}", id);
        getItems(id);
        Items i = Items.builder()
                .id(id)
                .itemsName(dto.getItemsName())
                .material(dto.getMaterial())
                .price(dto.getPrice())
                .promotionCode(dto.getPromotionCode())
                .build();
        repository.save(i);
    }
}