package com.der.controller;


import com.der.model.entity.Building;
import com.der.payload.request.BuildingPostRequest;
import com.der.service.BuildingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/saveBuilding")
    public ResponseEntity<Building> createBuilding(@Valid @RequestBody BuildingPostRequest buildingPostRequest) {

        Building buildings = buildingService.save(buildingPostRequest);
        return new ResponseEntity<>(buildings, HttpStatus.OK);
    }

    @PutMapping("/updateBuilding/{id}")
    public ResponseEntity<Building> updateBuilding(@PathVariable("id") Long id,
                                          @Valid @RequestBody BuildingPostRequest buildingPostRequest) {
        Building update = buildingService.update(id, buildingPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBuilding/{id}")
    ResponseEntity<?> deleteBuilding(@PathVariable Long id) {

        buildingService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
