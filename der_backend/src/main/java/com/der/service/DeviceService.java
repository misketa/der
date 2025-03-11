package com.der.service;

import com.der.model.entity.Device;
import com.der.payload.response.PageableResponse;


public interface DeviceService {

    PageableResponse<Device> findAll(int page, int size);

    void deleteDevice(Class<? extends Device> deviceType, Long id);
}
