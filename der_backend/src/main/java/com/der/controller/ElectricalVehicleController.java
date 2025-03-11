package com.der.controller;


import com.der.model.entity.ElectricalVehicle;
import com.der.payload.request.ElectricalVehiclePostRequest;
import com.der.service.ElectricalVehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class ElectricalVehicleController {

    private final ElectricalVehicleService electricalVehicleService;

    public ElectricalVehicleController(ElectricalVehicleService electricalVehicleService) {
        this.electricalVehicleService = electricalVehicleService;
    }

    @PostMapping("/saveElectricalVehicle")
    public ResponseEntity<ElectricalVehicle> createElectricalVehicle(@Valid @RequestBody ElectricalVehiclePostRequest electricalVehiclePostRequest) {

        ElectricalVehicle electricalVehicle = electricalVehicleService.save(electricalVehiclePostRequest);
        return new ResponseEntity<>(electricalVehicle, HttpStatus.OK);
    }

    @PutMapping("/updateElectricalVehicle/{id}")
    public ResponseEntity<ElectricalVehicle> updateElectricalVehicle(@PathVariable("id") Long id,
                                          @Valid @RequestBody ElectricalVehiclePostRequest electricalVehiclePostRequest) {
        ElectricalVehicle update = electricalVehicleService.update(id, electricalVehiclePostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/deleteElectricalVehicle/{id}")
    ResponseEntity<?> deleteElectricalVehicle(@PathVariable Long id) {

        electricalVehicleService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
