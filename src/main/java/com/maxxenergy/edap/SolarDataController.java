package com.maxxenergy.edap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/public")
public class SolarDataController {

    private SolarDataService solarDataService = new SolarDataService();

    @GetMapping("/data")
    public ResponseEntity<SolarData> getPublicSolarData() {
        SolarData data = solarDataService.getPublicData();
        return ResponseEntity.ok(data);
    }
}