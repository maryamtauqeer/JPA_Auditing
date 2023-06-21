package com.maryamt.jpaauditing.DTO;

import com.maryamt.jpaauditing.Entity.Items;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
//@EqualsAndHashCode
public class StoresDTO {
    int id;
    @NonNull
    String storesName;
    List<Items> items = new ArrayList<>();

}
