package com.der.repository;

import com.der.model.entity.ResidualElectricalLoads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidualElectricalLoadsRepository extends JpaRepository<ResidualElectricalLoads, Long> {
}
