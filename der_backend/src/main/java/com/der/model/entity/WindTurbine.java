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
@Table(name = "windTurbines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WindTurbine extends Device {
    @Column(name = "cutInWindSpeed", unique = false, nullable = false)
    private Long cutInWindSpeed;

    @Column(name = "outputVoltages", unique = false, nullable = false)
    private Long outputVoltages;

    @Column(name = "powerRatings", unique = false, nullable = false)
    private Long powerRatings;

    @Column(name = "currentRatings", unique = false, nullable = false)
    private Long currentRatings;
}
