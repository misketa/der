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
public class ResidualPostRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    private TypeEnum type = TypeEnum.RESIDUAL_ELECTRICAL_LOADS;
    private CategoryEnum category = CategoryEnum.CONSUMER;

    @Min(0)
    @Max(30)
    private Long maximumAvailablePower;


}

