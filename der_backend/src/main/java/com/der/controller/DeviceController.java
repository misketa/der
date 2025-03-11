package com.der.controller;


import com.der.model.entity.*;
import com.der.payload.response.PageableResponse;
import com.der.service.DeviceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.der.utils.RequestConstants.DEFAULT_PAGE_NUMBER;
import static com.der.utils.RequestConstants.DEFAULT_PAGE_SIZE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/devices")
@Slf4j
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public ResponseEntity<PageableResponse<Device>> findAll(
            @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) int size) {

        PageableResponse<Device> devices = deviceService.findAll(page, size);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @DeleteMapping("/{deviceType}/{id}")
    public ResponseEntity<Void> deleteDevice(
            @PathVariable String deviceType,
            @PathVariable Long id) {

        try {
            // Log inputs for debugging
            log.info("Attempting to delete device. Type: {}, ID: {}", deviceType, id);

            // Convert the device type string to the corresponding class
            Class<? extends Device> deviceClass = getDeviceClass(deviceType.toLowerCase());

            // Call the service method to delete the device
            deviceService.deleteDevice(deviceClass, id);

            log.info("Successfully deleted device. Type: {}, ID: {}", deviceType, id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            log.error("Invalid input: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            log.error("Unexpected error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    private static final Map<String, Class<? extends Device>> DEVICE_TYPE_MAP = Map.of(
            "battery", Battery.class,
            "building", Building.class,
            "electricalgrid", ElectricalGrid.class,
            "electricalvehicle", ElectricalVehicle.class,
            "photovoltaicpanel", PhotovoltaicPanel.class,
            "residualelectricalloads", ResidualElectricalLoads.class,
            "windturbine", WindTurbine.class
    );

    private Class<? extends Device> getDeviceClass(String deviceType) {
        // Store the original deviceType for logging purposes
        String normalizedDeviceType = deviceType.toLowerCase();

        Class<? extends Device> deviceClass = DEVICE_TYPE_MAP.get(normalizedDeviceType);

        if (deviceClass == null) {
            throw new IllegalArgumentException("Unsupported device type: " + deviceType);
        }

        return deviceClass;
    }

}
