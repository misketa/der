package com.der.service.impl;

import com.der.model.entity.Battery;
import com.der.model.entity.ResidualElectricalLoads;
import com.der.payload.request.BatteryPostRequest;
import com.der.payload.request.ResidualPostRequest;
import com.der.repository.ResidualElectricalLoadsRepository;
import com.der.service.ResidualElectricalLoadsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ResidualElectricalLoadsServiceImpl implements ResidualElectricalLoadsService {

    private final ResidualElectricalLoadsRepository residualElectricalLoadsRepository;

    @Override
    public ResidualElectricalLoads save(ResidualPostRequest residualPostRequest) {
        ResidualElectricalLoads residual = new ResidualElectricalLoads();
        residual.setName(residualPostRequest.getName());
        residual.setTypeEnum(residualPostRequest.getType());
        residual.setCategoryEnum(residualPostRequest.getCategory());
        residual.setMaxOutputPower(residualPostRequest.getMaximumAvailablePower());
        return residualElectricalLoadsRepository.save(residual);
    }

    @Override
    public void remove(Long id) { residualElectricalLoadsRepository.deleteById(id); }

    @Override
    public ResidualElectricalLoads update(Long id, ResidualPostRequest residualPostRequest) {
        ResidualElectricalLoads residualElectricalLoads =  residualElectricalLoadsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id " + id + " not found"));

        residualElectricalLoads.setName(residualPostRequest.getName());
        residualElectricalLoads.setMaxOutputPower(residualPostRequest.getMaximumAvailablePower());

        return residualElectricalLoadsRepository.save(residualElectricalLoads);
    }
}
