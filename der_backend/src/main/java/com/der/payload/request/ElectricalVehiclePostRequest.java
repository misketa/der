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
public class ElectricalVehiclePostRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    private TypeEnum type = TypeEnum.ELECTRICAL_VEHICLE;
    private CategoryEnum category = CategoryEnum.CONSUMER;

    @Min(0)
    @Max(125)
    private Long maximumAvailablePower;

    @Min(0)
    @Max(125)
    private Long motorPower;

    @Min(0)
    @Max(33)
    private Long battery;


}
