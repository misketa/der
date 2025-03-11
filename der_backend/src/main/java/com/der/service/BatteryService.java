package com.der.service;

import com.der.model.entity.Battery;
import com.der.payload.request.BatteryPostRequest;

public interface BatteryService {
    Battery save(BatteryPostRequest batteryPostRequest);

    void remove(Long id);

    Battery update(Long id, BatteryPostRequest batteryPostRequest);
}


