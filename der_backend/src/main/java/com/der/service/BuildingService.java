package com.der.service;

import com.der.model.entity.Building;
import com.der.payload.request.BuildingPostRequest;

public interface BuildingService {
    Building save(BuildingPostRequest buildingPostRequest);

    void remove(Long id);

    Building update(Long id, BuildingPostRequest buildingPostRequest);
}
