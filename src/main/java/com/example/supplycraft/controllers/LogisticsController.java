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

import com.example.supplycraft.models.DeliveryRoute;
import com.example.supplycraft.services.LogisticsService;
import com.example.supplycraft.dto.DeliveryRouteDTO;


@RestController
@RequestMapping("/api/logistics")
public class LogisticsController {

    @Autowired
    private LogisticsService logisticsService;

    @PostMapping("/delivery-routes")
    public ResponseEntity<?> createDeliveryRoute(@RequestBody DeliveryRouteDTO deliveryRouteDTO) {
        DeliveryRoute deliveryRoute = logisticsService.createDeliveryRoute(deliveryRouteDTO);
        return ResponseEntity.ok(deliveryRoute);
    }

    @GetMapping("/delivery-routes/{id}")
    public ResponseEntity<?> getDeliveryRouteById(@PathVariable("id") Long id) {
        DeliveryRoute deliveryRoute = logisticsService.getDeliveryRouteById(id);
        return ResponseEntity.ok(deliveryRoute);
    }
    



}
