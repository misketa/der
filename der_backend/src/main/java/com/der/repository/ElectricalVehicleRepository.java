package com.der.repository;

import com.der.model.entity.ElectricalVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalVehicleRepository extends JpaRepository<ElectricalVehicle, Long> {
}
