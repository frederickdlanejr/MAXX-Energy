package com.maxxenergy.edap;

import com.maxxenergy.edap.model.SolarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/public")
public class SolarDataController {

    @Autowired
    private SolarDataService solarDataService;

    @GetMapping("/data")
    public ResponseEntity<SolarData> getPublicSolarData() {
        SolarData data = solarDataService.getPublicData();
        return ResponseEntity.ok(data);
    }
}
