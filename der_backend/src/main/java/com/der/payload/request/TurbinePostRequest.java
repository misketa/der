package com.der.payload.request;

import com.der.customAnotations.ValueOf12Or48;
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
public class TurbinePostRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    private TypeEnum type = TypeEnum.WIND_TURBINE;
    private CategoryEnum category = CategoryEnum.PRODUCER;

    @Min(0)
    @Max(30)
    private Long maximumAvailablePower;

    @Min(1)
    @Max(3)
    private Long cutInWindSpeed;

    @ValueOf12Or48
    private Long outputVoltages;

    @Min(0)
    @Max(850)
    private Long powerRatings;

    @Min(0)
    @Max(30)
    private Long currentRatings;
}

