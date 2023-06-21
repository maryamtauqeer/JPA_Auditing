package com.maryamt.jpaauditing.Controller;

import com.maryamt.jpaauditing.DTO.StoresDTO;
import com.maryamt.jpaauditing.Entity.Stores;
import com.maryamt.jpaauditing.Entity.StoresResponse;
import com.maryamt.jpaauditing.Exception.EntityNotFoundException;
import com.maryamt.jpaauditing.Service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoresController {
    @Autowired
    StoresService service;


    @PostMapping
    public ResponseEntity<StoresResponse> createStore(@RequestBody StoresDTO dto) {
        StoresResponse s=service.createStore(dto);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<StoresResponse> getStores() {
        return service.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StoresResponse getStoresById(@PathVariable("id") final int id)
            throws EntityNotFoundException {
        final Stores p = service.getStores(id);
        return StoresResponse.from(p);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateStores(@PathVariable("id") final int id,
                                              @RequestBody final StoresDTO dto) throws EntityNotFoundException {
        service.updateStores(id, dto);
        return new ResponseEntity<>("Store updated successfully", HttpStatus.OK);
    }

}
