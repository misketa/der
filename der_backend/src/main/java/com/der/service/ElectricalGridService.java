package com.der.service;

import com.der.model.entity.ElectricalGrid;
import com.der.payload.request.ElectricalGridPostRequest;

public interface ElectricalGridService {
    ElectricalGrid save(ElectricalGridPostRequest electricalGridPostRequest);

    void remove(Long id);

    ElectricalGrid update(Long id, ElectricalGridPostRequest electricalGridPostRequest);
}
