package com.maryamt.jpaauditing.Entity;

import com.maryamt.jpaauditing.DTO.ItemsDTO;
import lombok.Getter;

@Getter
//@EqualsAndHashCode(callSuper = true)
public class ItemsResponse extends ItemsDTO {

    String createdBy;
    String creationDate;
    String lastModifiedBy;
    String lastModifiedDate;

    private ItemsResponse(
            final int id,
            final String itemsName,
            final String material,
            final String price,
            final String promotionCode,
            final String createdBy,
            final String creationDate,
            final String lastModifiedBy,
            final String lastModifiedDate) {
        super(id, itemsName, material, price, promotionCode);
        this.createdBy=createdBy;
        this.creationDate = creationDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static ItemsResponse from(final Items items) {
        return new ItemsResponse(items.getId(),
                items.getItemsName(),
                items.getItemsName(),
                items.getPrice(),
                items.getPromotionCode(),
                items.getCreatedBy(),
                items.getCreationDate().toString(),
                items.getLastModifiedBy(),
                items.getLastModifiedDate().toString());
    }
}
