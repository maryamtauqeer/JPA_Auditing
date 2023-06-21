package com.maryamt.jpaauditing.DTO;

import com.maryamt.jpaauditing.Entity.Stores;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
//@EqualsAndHashCode
public class ItemsDTO{

    int id;
    @NonNull
    String itemsName;
    String material;
    String price;
    String promotionCode;
    Stores store_id;
}