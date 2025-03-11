package com.der.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "batterys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Battery extends Device {
    @Column(name = "capacity", nullable = false)
    private Long capacity;

    @Column(name = "state_of_charge_min", nullable = false)
    private Long stateOfChargeMin;

    @Column(name = "state_of_charge_max", nullable = false)
    private Long stateOfChargeMax;
}
