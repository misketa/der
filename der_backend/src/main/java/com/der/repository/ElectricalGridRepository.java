package com.der.repository;

import com.der.model.entity.ElectricalGrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalGridRepository extends JpaRepository<ElectricalGrid, Long> {
}
