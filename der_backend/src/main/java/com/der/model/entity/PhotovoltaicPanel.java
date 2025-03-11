package com.der.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photovoltaicPanels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotovoltaicPanel extends Device {

    @Column(name = "outputPower", unique = false, nullable = false)
    private Long outputPower;

    @Column(name = "voltage", unique = false, nullable = false)
    private Long voltage;

    @Column(name = "current", unique = false, nullable = false)
    private Long current;

    @Column(name = "openCircuitVoltage", unique = false, nullable = false)
    private Long openCircuitVoltage;

    @Column(name = "shortCircuitCurrent", unique = false, nullable = false)
    private Long shortCircuitCurrent;

    @Column(name = "powerTolerance", unique = false, nullable = false)
    private Long powerTolerance;
}
