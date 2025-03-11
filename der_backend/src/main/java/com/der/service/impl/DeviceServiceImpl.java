package com.der.service.impl;

import com.der.model.entity.*;
import com.der.payload.response.PageableResponse;
import com.der.repository.*;
import com.der.service.DeviceService;
import com.der.utils.ApplicationConstants;
import com.der.utils.ApplicationUtilities;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService {

    private final BatteryRepository batteryRepository;
    private final BuildingRepository buildingRepository;
    private final ElectricalGridRepository electricalGridRepository;
    private final ElectricalVehicleRepository electricalVehicleRepository;
    private final PhotovoltaicPanelRepository photovoltaicPanelRepository;
    private final ResidualElectricalLoadsRepository residualElectricalLoadsRepository;
    private final WindTurbineRepository windTurbineRepository;

    private final Map<Class<? extends Device>, JpaRepository<?, Long>> repositoryMap = new HashMap<>();

    @Override
    public PageableResponse<Device> findAll(int page, int size) {
        ApplicationUtilities.validateRequestPageAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, ApplicationConstants.CREATED_AT);

        // Fetch each device type separately
        List<Device> allDevices = new ArrayList<>();
        allDevices.addAll(batteryRepository.findAll());
        allDevices.addAll(buildingRepository.findAll());
        allDevices.addAll(electricalGridRepository.findAll());
        allDevices.addAll(electricalVehicleRepository.findAll());
        allDevices.addAll(photovoltaicPanelRepository.findAll());
        allDevices.addAll(residualElectricalLoadsRepository.findAll());
        allDevices.addAll(windTurbineRepository.findAll());

        // Sort and paginate the full list manually
        int start = Math.min((int) pageable.getOffset(), allDevices.size());
        int end = Math.min((start + pageable.getPageSize()), allDevices.size());
        Page<Device> paginatedDevices = new PageImpl<>(allDevices.subList(start, end), pageable, allDevices.size());

        List<Device> content = paginatedDevices.getNumberOfElements() == 0 ? Collections.emptyList() : paginatedDevices.getContent();

        return new PageableResponse<>(content,
                paginatedDevices.getNumber(),
                paginatedDevices.getSize(),
                paginatedDevices.getTotalElements(),
                paginatedDevices.getTotalPages());
    }

    @Override
    public void deleteDevice(Class<? extends Device> deviceType, Long id) {
        // Validate inputs
        ApplicationUtilities.validateId(id);

        // Look up the repository for the given device type
        JpaRepository<?, Long> repository = repositoryMap.get(deviceType);
        if (repository == null) {
            throw new IllegalArgumentException("Unsupported device type: " + deviceType.getSimpleName());
        }

        // Delete the device by ID
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Device with ID " + id + " not found for type: " + deviceType.getSimpleName());
        }

        repository.deleteById(id);
        log.info("Deleted device of type {} with ID {}", deviceType.getSimpleName(), id);
    }
}
