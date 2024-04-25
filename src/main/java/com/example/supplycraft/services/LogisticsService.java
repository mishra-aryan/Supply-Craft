package com.example.supplycraft.services;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.DeliveryRoute;
import com.example.supplycraft.repositories.DeliveryRouteRepository;
import com.example.supplycraft.dto.DeliveryRouteDTO;

@Service
public class LogisticsService {

    @Autowired
    private DeliveryRouteRepository deliveryRouteRepository;

    public DeliveryRoute createDeliveryRoute(DeliveryRouteDTO deliveryRouteDTO) {
        // Create a new delivery route entity
        DeliveryRoute newDeliveryRoute = new DeliveryRoute();
        newDeliveryRoute.setRouteNumber(deliveryRouteDTO.getRouteNumber());
        newDeliveryRoute.setStartPoint(deliveryRouteDTO.getStartPoint());
        newDeliveryRoute.setEndPoint(deliveryRouteDTO.getEndPoint());
        newDeliveryRoute.setStartDate(deliveryRouteDTO.getStartDate());
        newDeliveryRoute.setEndDate(deliveryRouteDTO.getEndDate());
        newDeliveryRoute.setDistance(deliveryRouteDTO.getDistance());
        newDeliveryRoute.setEstimatedDuration(deliveryRouteDTO.getEstimatedDuration());
        // Set other properties as needed
        
        // Save and return the new delivery route
        return deliveryRouteRepository.save(newDeliveryRoute);
    }

    public DeliveryRoute getDeliveryRouteById(Long id) {
        // Retrieve the delivery route by ID
        return deliveryRouteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Delivery route not found with id: " + id));
    }

    // Implement other methods as needed
}
