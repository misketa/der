package com.der.service.impl;

import com.der.model.entity.Battery;
import com.der.model.entity.ElectricalGrid;
import com.der.payload.request.BatteryPostRequest;
import com.der.payload.request.ElectricalGridPostRequest;
import com.der.repository.ElectricalGridRepository;
import com.der.service.ElectricalGridService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ElectricalGridServiceImpl implements ElectricalGridService {

    private final ElectricalGridRepository electricalGridRepository;

    @Override
    public ElectricalGrid save(ElectricalGridPostRequest electricalGridPostRequest) {

        ElectricalGrid electricalGrid = new ElectricalGrid();
        electricalGrid.setName(electricalGridPostRequest.getName());
        electricalGrid.setTypeEnum(electricalGridPostRequest.getType());
        electricalGrid.setCategoryEnum(electricalGridPostRequest.getCategory());
        electricalGrid.setCo2EmissionRate(electricalGridPostRequest.getCo2EmissionRate());
        electricalGrid.setMaxOutputPower(electricalGridPostRequest.getMaximumAvailablePower());

        return electricalGridRepository.save(electricalGrid);

    }

    @Override
    public void remove(Long id) { electricalGridRepository.deleteById(id); }

    @Override
    public ElectricalGrid update(Long id, ElectricalGridPostRequest electricalGridPostRequest) {
        ElectricalGrid electricalGrid =  electricalGridRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id " + id + " not found"));

        electricalGrid.setName(electricalGridPostRequest.getName());
        electricalGrid.setMaxOutputPower(electricalGridPostRequest.getMaximumAvailablePower());

        return electricalGridRepository.save(electricalGrid);
    }
}
