package com.der.controller;

import com.der.model.entity.PhotovoltaicPanel;
import com.der.payload.request.PanelPostRequest;
import com.der.service.PhotovoltaicPanelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/devices")
@CrossOrigin(origins = "http://localhost:4200")
public class PhotovoltaicPanelController {

    private final PhotovoltaicPanelService photovoltaicPanelService;


    public PhotovoltaicPanelController(PhotovoltaicPanelService photovoltaicPanelService) {
        this.photovoltaicPanelService = photovoltaicPanelService;
    }

    @PostMapping("/savePanel")
    public ResponseEntity<PhotovoltaicPanel> createPanel(@Valid @RequestBody PanelPostRequest panelPostRequest) {

        PhotovoltaicPanel photovoltaicPanel = photovoltaicPanelService.save(panelPostRequest);
        return new ResponseEntity<>(photovoltaicPanel, HttpStatus.OK);
    }

    @PutMapping("/updatePanel/{id}")
    public ResponseEntity<PhotovoltaicPanel> updatePanel(@PathVariable("id") Long id,
                                          @Valid @RequestBody PanelPostRequest panelPostRequest) {
        PhotovoltaicPanel update = photovoltaicPanelService.update(id, panelPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/deletePanel/{id}")
    ResponseEntity<?> deletePanel(@PathVariable Long id) {

        photovoltaicPanelService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
