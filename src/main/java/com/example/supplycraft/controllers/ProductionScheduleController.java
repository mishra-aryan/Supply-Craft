package com.example.supplycraft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplycraft.models.ProductionSchedule;
import com.example.supplycraft.services.ProductionScheduleService;
import com.example.supplycraft.dto.ProductionScheduleDTO;

@RestController
@RequestMapping("/api/production-schedules")
public class ProductionScheduleController {

    @Autowired
    private ProductionScheduleService productionScheduleService;

    @PostMapping
    public ResponseEntity<?> createProductionSchedule(@RequestBody ProductionScheduleDTO productionScheduleDTO) {
        ProductionSchedule productionSchedule = productionScheduleService.createProductionSchedule(productionScheduleDTO);
        return ResponseEntity.ok(productionSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductionScheduleById(@PathVariable("id") Long id) {
        ProductionSchedule productionSchedule = productionScheduleService.getProductionScheduleById(id);
        return ResponseEntity.ok(productionSchedule);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductionSchedule(@PathVariable("id") Long id, @RequestBody ProductionScheduleDTO productionScheduleDTO) {
        ProductionSchedule updatedProductionSchedule = productionScheduleService.updateProductionSchedule(id, productionScheduleDTO);
        return ResponseEntity.ok(updatedProductionSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductionSchedule(@PathVariable("id") Long id) {
        productionScheduleService.deleteProductionSchedule(id);
        return ResponseEntity.ok("Production schedule deleted successfully");
    }
}
