package com.der.repository;

import com.der.model.entity.WindTurbine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindTurbineRepository extends JpaRepository<WindTurbine, Long> {
}
