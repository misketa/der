package com.der.service.impl;

import com.der.model.entity.Battery;
import com.der.model.entity.WindTurbine;
import com.der.payload.request.BatteryPostRequest;
import com.der.payload.request.TurbinePostRequest;
import com.der.repository.WindTurbineRepository;
import com.der.service.WindTurbineService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class WindTurbineServiceImpl implements WindTurbineService {

    private final WindTurbineRepository windTurbineRepository;

    @Override
    public WindTurbine save(TurbinePostRequest turbinePostRequest) {
        WindTurbine windTurbine = new WindTurbine();
        windTurbine.setName(turbinePostRequest.getName());
        windTurbine.setTypeEnum(turbinePostRequest.getType());
        windTurbine.setCategoryEnum(turbinePostRequest.getCategory());
        windTurbine.setMaxOutputPower(turbinePostRequest.getMaximumAvailablePower());
        windTurbine.setCutInWindSpeed(turbinePostRequest.getCutInWindSpeed());
        windTurbine.setOutputVoltages(turbinePostRequest.getOutputVoltages());
        windTurbine.setPowerRatings(turbinePostRequest.getPowerRatings());
        windTurbine.setCurrentRatings(turbinePostRequest.getCurrentRatings());

        return windTurbineRepository.save(windTurbine);
    }

    @Override
    public void remove(Long id) { windTurbineRepository.deleteById(id); }

    @Override
    public WindTurbine update(Long id, TurbinePostRequest turbinePostRequest) {
        WindTurbine windTurbine =  windTurbineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id " + id + " not found"));

        windTurbine.setName(turbinePostRequest.getName());
        windTurbine.setMaxOutputPower(turbinePostRequest.getMaximumAvailablePower());

        return windTurbineRepository.save(windTurbine);
    }
}
