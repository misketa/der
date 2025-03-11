package com.der.service.impl;

import com.der.model.entity.Battery;
import com.der.model.entity.Building;
import com.der.payload.request.BatteryPostRequest;
import com.der.payload.request.BuildingPostRequest;
import com.der.repository.BuildingRepository;
import com.der.service.BuildingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    @Override
    public Building save(BuildingPostRequest buildingPostRequest) {
        Building building = new Building();
        building.setName(buildingPostRequest.getName());
        building.setTypeEnum(buildingPostRequest.getType());
        building.setCategoryEnum(buildingPostRequest.getCategory());
        building.setMaxOutputPower(buildingPostRequest.getMaximumAvailablePower());

        return buildingRepository.save(building);
    }

    @Override
    public void remove(Long id) { buildingRepository.deleteById(id); }

    @Override
    public Building update(Long id, BuildingPostRequest buildingPostRequest) {
        Building building =  buildingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id " + id + " not found"));

        building.setName(buildingPostRequest.getName());
        building.setMaxOutputPower(buildingPostRequest.getMaximumAvailablePower());

        return buildingRepository.save(building);
    }
}
