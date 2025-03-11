package com.der.controller;


import com.der.model.entity.ElectricalGrid;
import com.der.payload.request.ElectricalGridPostRequest;
import com.der.service.ElectricalGridService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class ElectricalGridController {

    private final ElectricalGridService electricalGridService;


    public ElectricalGridController(ElectricalGridService electricalGridService) {
        this.electricalGridService = electricalGridService;
    }

    @PostMapping("/saveElectricalGrid")
    public ResponseEntity<ElectricalGrid> createElectricalGrid(@Valid @RequestBody ElectricalGridPostRequest electricalGridPostRequest) {

        ElectricalGrid electricalGrid = electricalGridService.save(electricalGridPostRequest);
        return new ResponseEntity<>(electricalGrid, HttpStatus.OK);
    }

    @PutMapping("/updateElectricalGrid/{id}")
    public ResponseEntity<ElectricalGrid> updateElectricalGrid(@PathVariable("id") Long id,
                                          @Valid @RequestBody ElectricalGridPostRequest electricalGridPostRequest) {
        ElectricalGrid update = electricalGridService.update(id, electricalGridPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/deleteElectricalGrid/{id}")
    ResponseEntity<?> deleteElectricalGrid(@PathVariable Long id) {

        electricalGridService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
