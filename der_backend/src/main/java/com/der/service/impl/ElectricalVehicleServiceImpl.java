package com.der.service.impl;

import com.der.model.entity.Battery;
import com.der.model.entity.ElectricalVehicle;
import com.der.payload.request.BatteryPostRequest;
import com.der.payload.request.ElectricalVehiclePostRequest;
import com.der.repository.ElectricalVehicleRepository;
import com.der.service.ElectricalVehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ElectricalVehicleServiceImpl  implements ElectricalVehicleService {

    private final ElectricalVehicleRepository electricalVehicleRepository;


    @Override
    public ElectricalVehicle save(ElectricalVehiclePostRequest electricalVehiclePostRequest) {
        ElectricalVehicle electricalVehicle = new ElectricalVehicle();
        electricalVehicle.setName(electricalVehiclePostRequest.getName());
        electricalVehicle.setTypeEnum(electricalVehiclePostRequest.getType());
        electricalVehicle.setCategoryEnum(electricalVehiclePostRequest.getCategory());
        electricalVehicle.setMotorPower(electricalVehiclePostRequest.getMotorPower());
        electricalVehicle.setBattery(electricalVehiclePostRequest.getBattery());
        electricalVehicle.setMaxOutputPower(electricalVehiclePostRequest.getMaximumAvailablePower());
        return electricalVehicleRepository.save(electricalVehicle);
    }

    @Override
    public void remove(Long id) { electricalVehicleRepository.deleteById(id); }

    @Override
    public ElectricalVehicle update(Long id, ElectricalVehiclePostRequest electricalVehiclePostRequest) {
        ElectricalVehicle electricalVehicle =  electricalVehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id " + id + " not found"));

        electricalVehicle.setName(electricalVehiclePostRequest.getName());
        electricalVehicle.setMaxOutputPower(electricalVehiclePostRequest.getMaximumAvailablePower());

        return electricalVehicleRepository.save(electricalVehicle);
    }
}
