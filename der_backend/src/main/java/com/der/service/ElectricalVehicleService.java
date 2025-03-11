package com.der.service;

import com.der.model.entity.ElectricalVehicle;
import com.der.payload.request.ElectricalVehiclePostRequest;

public interface ElectricalVehicleService {
    ElectricalVehicle save(ElectricalVehiclePostRequest electricalVehiclePostRequest);

    void remove(Long id);

    ElectricalVehicle update(Long id, ElectricalVehiclePostRequest electricalVehiclePostRequest);
}
