package com.der.service;

import com.der.model.entity.PhotovoltaicPanel;
import com.der.payload.request.PanelPostRequest;

public interface PhotovoltaicPanelService {
    PhotovoltaicPanel save(PanelPostRequest panelPostRequest);

    void remove(Long id);

    PhotovoltaicPanel update(Long id, PanelPostRequest panelPostRequest);
}
