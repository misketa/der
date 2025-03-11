package com.der.controller;

import com.der.model.entity.WindTurbine;
import com.der.payload.request.TurbinePostRequest;
import com.der.service.WindTurbineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class WindTurbineController {

    private final WindTurbineService windTurbineService;

    public WindTurbineController(WindTurbineService windTurbineService) {
        this.windTurbineService = windTurbineService;
    }

    @PostMapping("/saveTurbine")
    public ResponseEntity<WindTurbine> createTurbine(@Valid @RequestBody TurbinePostRequest turbinePostRequest) {

        WindTurbine windTurbine = windTurbineService.save(turbinePostRequest);
        return new ResponseEntity<>(windTurbine, HttpStatus.OK);
    }

    @PutMapping("/updateWindTurbine/{id}")
    public ResponseEntity<WindTurbine> updateTurbine(@PathVariable("id") Long id,
                                          @Valid @RequestBody TurbinePostRequest turbinePostRequest) {
        WindTurbine update = windTurbineService.update(id, turbinePostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


    @DeleteMapping("/deleteTurbine/{id}")
    ResponseEntity<?> deleteTurbine(@PathVariable Long id) {

        windTurbineService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
