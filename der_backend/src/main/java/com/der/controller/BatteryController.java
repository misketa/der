package com.der.controller;


import com.der.model.entity.Battery;
import com.der.payload.request.BatteryPostRequest;
import com.der.service.BatteryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping("/saveBattery")
    public ResponseEntity<Battery> createBattery(@Valid @RequestBody BatteryPostRequest batteryPostRequest) {

        Battery batterys = batteryService.save(batteryPostRequest);
        return new ResponseEntity<>(batterys, HttpStatus.OK);
    }

    @PutMapping("/updateBattery/{id}")
    public ResponseEntity<Battery> updateBattery(@PathVariable("id") Long id,
                                          @Valid @RequestBody BatteryPostRequest batteryPostRequest) {
        Battery update = batteryService.update(id, batteryPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBattery/{id}")
    ResponseEntity<?> deleteBattery(@PathVariable Long id) {

        batteryService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
