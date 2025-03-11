package com.der.service.impl;

import com.der.model.entity.Battery;
import com.der.model.entity.PhotovoltaicPanel;
import com.der.payload.request.BatteryPostRequest;
import com.der.payload.request.PanelPostRequest;
import com.der.repository.PhotovoltaicPanelRepository;
import com.der.service.PhotovoltaicPanelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class PhotovoltaicPanelServiceImpl implements PhotovoltaicPanelService {

    private final PhotovoltaicPanelRepository photovoltaicPanelRepository;


    @Override
    public PhotovoltaicPanel save(PanelPostRequest panelPostRequest) {
        PhotovoltaicPanel photovoltaicPanel = new PhotovoltaicPanel();
        photovoltaicPanel.setName(panelPostRequest.getName());
        photovoltaicPanel.setTypeEnum(panelPostRequest.getType());
        photovoltaicPanel.setCategoryEnum(panelPostRequest.getCategory());
        photovoltaicPanel.setMaxOutputPower(panelPostRequest.getMaximumAvailablePower());
        photovoltaicPanel.setOutputPower(panelPostRequest.getOutput());
        photovoltaicPanel.setVoltage(panelPostRequest.getVoltage());
        photovoltaicPanel.setCurrent(panelPostRequest.getCurrent());
        photovoltaicPanel.setOpenCircuitVoltage(panelPostRequest.getOpenCircuitVoltage());
        photovoltaicPanel.setShortCircuitCurrent(panelPostRequest.getShortCircuitCurrent());
        photovoltaicPanel.setPowerTolerance(panelPostRequest.getPowerTolerance());

        return photovoltaicPanelRepository.save(photovoltaicPanel);
    }

    @Override
    public void remove(Long id) { photovoltaicPanelRepository.deleteById(id); }

    @Override
    public PhotovoltaicPanel update(Long id, PanelPostRequest panelPostRequest) {
        PhotovoltaicPanel photovoltaicPanel =  photovoltaicPanelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student with id " + id + " not found"));

        photovoltaicPanel.setName(panelPostRequest.getName());
        photovoltaicPanel.setMaxOutputPower(panelPostRequest.getMaximumAvailablePower());

        return photovoltaicPanelRepository.save(photovoltaicPanel);
    }
}
