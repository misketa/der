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
public class PhotovoltaicPanelDto implements Serializable {

    private String name;
    private TypeEnum typeEnum;
    private CategoryEnum categoryEnum;
    private Long maxOutputPower;
    private Double outputPower;
    private Double voltage;
    private Double current;
    private Double openCircuitVoltage;
    private Double shortCircuitCurrent;
    private Double powerTolerance;
}
