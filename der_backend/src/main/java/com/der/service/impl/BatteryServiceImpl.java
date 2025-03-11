package com.der.service.impl;

import com.der.model.entity.Battery;
import com.der.payload.request.BatteryPostRequest;
import com.der.repository.BatteryRepository;
import com.der.service.BatteryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;


    @Override
    public Battery save(BatteryPostRequest batteryPostRequest) {
        Battery battery = new Battery();
        battery.setName(batteryPostRequest.getName());
        battery.setTypeEnum(batteryPostRequest.getType());
        battery.setCategoryEnum(batteryPostRequest.getCategory());
        battery.setCapacity(batteryPostRequest.getCapacity());
        battery.setStateOfChargeMin(batteryPostRequest.getStateOfChargeMin());
        battery.setStateOfChargeMax(batteryPostRequest.getStateOfChargeMax());
        battery.setMaxOutputPower(batteryPostRequest.getMaximumAvailablePower());

        return batteryRepository.save(battery);

    }

    @Override
    public void remove(Long id) { batteryRepository.deleteById(id); }

    @Override
    public Battery update(Long id, BatteryPostRequest batteryPostRequest) {
        Battery battery =  batteryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id " + id + " not found"));

        battery.setName(batteryPostRequest.getName());
        battery.setMaxOutputPower(batteryPostRequest.getMaximumAvailablePower());

        return batteryRepository.save(battery);
    }


}
