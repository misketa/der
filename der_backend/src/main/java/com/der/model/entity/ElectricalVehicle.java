package com.der.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "electricalVehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectricalVehicle extends Device {

    @Column(name = "motorPower", unique = false, nullable = false)
    private Long motorPower;

    @Column(name = "battery", unique = false, nullable = false)
    private Long battery;
}
