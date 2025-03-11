package com.der.payload.request;

import com.der.model.entity.CategoryEnum;
import com.der.model.entity.TypeEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PanelPostRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    private TypeEnum type = TypeEnum.PHOTOVOLTAIC_PANEL;
    private CategoryEnum category = CategoryEnum.PRODUCER;

    @Min(0)
    @Max(10)
    private Long maximumAvailablePower;

    @Min(0)
    @Max(300)
    private Long output;

    @Min(0)
    @Max(30)
    private Long voltage;

    @Min(0)
    @Max(10)
    private Long current;

    @Min(0)
    @Max(40)
    private Long openCircuitVoltage;

    @Min(0)
    @Max(10)
    private Long shortCircuitCurrent;

    @Min(-3)
    @Max(3)
    private Long powerTolerance;
}



