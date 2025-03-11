package com.der.model.dto;

import com.der.model.entity.CategoryEnum;
import com.der.model.entity.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BatteryDto  implements Serializable {


    //TODO dodati validacije poljima
    private String name;
    private TypeEnum typeEnum;
    private CategoryEnum categoryEnum;
    private Long maxOutputPower;
    private Double capacity;
    private Double stateOfChargeMin;
    private Double stateOfChargeMax;

}
