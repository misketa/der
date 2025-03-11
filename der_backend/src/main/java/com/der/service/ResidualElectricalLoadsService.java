package com.der.service;

import com.der.model.entity.ResidualElectricalLoads;
import com.der.payload.request.ResidualPostRequest;

public interface ResidualElectricalLoadsService {
    ResidualElectricalLoads save(ResidualPostRequest residualPostRequest);

    void remove(Long id);

    ResidualElectricalLoads update(Long id, ResidualPostRequest residualPostRequest);
}

