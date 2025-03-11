package com.der.service;

import com.der.model.entity.WindTurbine;
import com.der.payload.request.TurbinePostRequest;

public interface WindTurbineService {
    WindTurbine save(TurbinePostRequest turbinePostRequest);

    void remove(Long id);

    WindTurbine update(Long id, TurbinePostRequest turbinePostRequest);
}
