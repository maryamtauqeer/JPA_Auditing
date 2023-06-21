package com.maryamt.jpaauditing.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_store_id", referencedColumnName = "id")
    private Stores store_id;

}