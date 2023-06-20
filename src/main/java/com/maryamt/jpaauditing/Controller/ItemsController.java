package com.maryamt.jpaauditing.Controller;

import com.maryamt.jpaauditing.DTO.ItemsDTO;
import com.maryamt.jpaauditing.Entity.Items;
import com.maryamt.jpaauditing.Entity.ItemsResponse;
import com.maryamt.jpaauditing.Exception.EntityNotFoundException;
import com.maryamt.jpaauditing.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemsController {

    @Autowired
    ItemsService service;


    @PostMapping
    public ResponseEntity<ItemsResponse> createItem(@RequestBody ItemsDTO dto) {
        ItemsResponse i=service.createItem(dto);
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ItemsResponse> getItems() {
        return service.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ItemsResponse getItemsById(@PathVariable("id") final int id)
            throws EntityNotFoundException {
        final Items p = service.getItems(id);
        return ItemsResponse.from(p);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateItems(@PathVariable("id") final int id,
                            @RequestBody final ItemsDTO dto) throws EntityNotFoundException {
        service.updateItems(id, dto);
        return new ResponseEntity<>("Item updated successfully", HttpStatus.OK);
    }
}