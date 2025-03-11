package com.der.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "electricalGrids")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectricalGrid extends Device {

    @Column(name = "co2EmissionRate", unique = false, nullable = false)
    private Long co2EmissionRate;
}
