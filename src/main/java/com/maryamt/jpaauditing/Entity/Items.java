package com.maryamt.jpaauditing.Entity;

import com.maryamt.jpaauditing.Audit.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Data
//@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Items")
@Component
public class Items extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name", nullable = false)
    String itemsName;

    String material;

    String price;

    @Column(name = "promotionCode")
    String promotionCode;

}