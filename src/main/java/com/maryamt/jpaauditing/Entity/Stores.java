package com.maryamt.jpaauditing.Entity;

import com.maryamt.jpaauditing.Audit.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
//@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Stores")
@Component
public class Stores extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name", nullable = false)
    String storesName;

    @OneToMany(
            mappedBy = "store_id",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Items> items = new ArrayList<>();


}
