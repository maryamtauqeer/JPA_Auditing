package com.maryamt.jpaauditing.Repository;

import com.maryamt.jpaauditing.Entity.Stores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Integer> {
}
