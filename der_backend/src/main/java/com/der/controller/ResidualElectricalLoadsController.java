package com.der.controller;

import com.der.model.entity.ResidualElectricalLoads;
import com.der.payload.request.ResidualPostRequest;
import com.der.service.ResidualElectricalLoadsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class ResidualElectricalLoadsController {

    private final ResidualElectricalLoadsService residualElectricalLoadsService;


    public ResidualElectricalLoadsController(ResidualElectricalLoadsService residualElectricalLoadsService) {
        this.residualElectricalLoadsService = residualElectricalLoadsService;
    }

    @PostMapping("/saveResidual")
    public ResponseEntity<ResidualElectricalLoads> createResidual(@Valid @RequestBody ResidualPostRequest residualPostRequest) {

        ResidualElectricalLoads residual = residualElectricalLoadsService.save(residualPostRequest);
        return new ResponseEntity<>(residual, HttpStatus.OK);
    }

    @PutMapping("/updateResidual/{id}")
    public ResponseEntity<ResidualElectricalLoads> updateResidual(@PathVariable("id") Long id,
                                          @Valid @RequestBody ResidualPostRequest residualPostRequest) {
        ResidualElectricalLoads update = residualElectricalLoadsService.update(id, residualPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/deleteResidual/{id}")
    ResponseEntity<?> deleteResidual(@PathVariable Long id) {

        residualElectricalLoadsService.remove(id);

        return ResponseEntity.noContent().build();
    }
}


