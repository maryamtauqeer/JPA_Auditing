package com.maryamt.jpaauditing.Entity;

import com.maryamt.jpaauditing.DTO.StoresDTO;
import lombok.Getter;

import java.util.List;

@Getter
//@EqualsAndHashCode(callSuper = true)
public class StoresResponse extends StoresDTO {
    String createdBy;
    String creationDate;
    String lastModifiedBy;
    String lastModifiedDate;

    private StoresResponse(
            final int id,
            final String storesName,
            final List<Items> items,
            final String createdBy,
            final String creationDate,
            final String lastModifiedBy,
            final String lastModifiedDate) {
        super(id, storesName, items);
//        super(id, storesName);
        this.createdBy=createdBy;
        this.creationDate = creationDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static StoresResponse from(final Stores stores) {
        return new StoresResponse(stores.getId(),
                stores.getStoresName(),
                stores.getItems(),
                stores.getCreatedBy(),
                stores.getCreationDate().toString(),
                stores.getLastModifiedBy(),
                stores.getLastModifiedDate().toString());
    }
}
