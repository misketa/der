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
public class BatteryPostRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    private TypeEnum type = TypeEnum.BATTERY;
    private CategoryEnum category = CategoryEnum.MIXED;

    @Min(0)
    @Max(10)
    private Long capacity;

    @Min(0)
    @Max(20)
    private Long stateOfChargeMin;

    @Min(90)
    @Max(100)
    private Long stateOfChargeMax;

    @Min(0)
    @Max(10)
    private Long maximumAvailablePower;
}
