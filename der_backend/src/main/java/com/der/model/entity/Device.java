package com.der.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public abstract class Device  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_enum", nullable = false)
    private TypeEnum typeEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_enum", nullable = false)
    private CategoryEnum categoryEnum;

    @Column(name = "max_output_power", nullable = false)
    private Long maxOutputPower;
}
