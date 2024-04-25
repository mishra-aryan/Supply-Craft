package com.example.supplycraft.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.DeliveryRoute;
import com.example.supplycraft.repositories.DeliveryRouteRepository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class DeliveryRouteService {

    @Autowired
    private DeliveryRouteRepository deliveryRouteRepository;

    public List<DeliveryRoute> getAllDeliveryRoutes() {
        return deliveryRouteRepository.findAll();
    }

    public DeliveryRoute getDeliveryRouteById(Long id) {
        return deliveryRouteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DeliveryRoute not found with id: " + id));
    }

    public DeliveryRoute createDeliveryRoute(DeliveryRoute deliveryRoute) {
        // Add any validation or business logic here
        return deliveryRouteRepository.save(deliveryRoute);
    }

    public DeliveryRoute updateDeliveryRoute(Long id, DeliveryRoute updatedDeliveryRoute) {
        DeliveryRoute existingDeliveryRoute = getDeliveryRouteById(id);

        // Update fields from updatedDeliveryRoute
        String newRouteNumber = updatedDeliveryRoute.getRouteNumber();
        if (newRouteNumber != null && !newRouteNumber.isEmpty()) {
            existingDeliveryRoute.setRouteNumber(newRouteNumber);
        }

        String newStartPoint = updatedDeliveryRoute.getStartPoint();
        if (newStartPoint != null && !newStartPoint.isEmpty()) {
            existingDeliveryRoute.setStartPoint(newStartPoint);
        }

        String newEndPoint = updatedDeliveryRoute.getEndPoint();
        if (newEndPoint != null && !newEndPoint.isEmpty()) {
            existingDeliveryRoute.setEndPoint(newEndPoint);
        }

        LocalDate newStartDate = updatedDeliveryRoute.getStartDate();
        if (newStartDate != null) {
            existingDeliveryRoute.setStartDate(newStartDate);
        }

        LocalDate newEndDate = updatedDeliveryRoute.getEndDate();
        if (newEndDate != null) {
            existingDeliveryRoute.setEndDate(newEndDate);
        }

        Integer newDistance = updatedDeliveryRoute.getDistance();
        if (newDistance != null && newDistance > 0) {
            existingDeliveryRoute.setDistance(newDistance);
        }

        Integer newEstimatedDuration = updatedDeliveryRoute.getEstimatedDuration();
        if (newEstimatedDuration != null && newEstimatedDuration > 0) {
            existingDeliveryRoute.setEstimatedDuration(newEstimatedDuration);
        }

        // Validate the updated delivery route
        validateDeliveryRoute(existingDeliveryRoute);

        // Save the updated delivery route
        return deliveryRouteRepository.save(existingDeliveryRoute);
    }

    public void deleteDeliveryRoute(Long id) {
        DeliveryRoute existingDeliveryRoute = getDeliveryRouteById(id);
        deliveryRouteRepository.delete(existingDeliveryRoute);
    }

    private void validateDeliveryRoute(DeliveryRoute deliveryRoute) {
        // Add validation logic here, for example:
        // Ensure start and end points are different
        if (deliveryRoute.getStartPoint() != null && deliveryRoute.getEndPoint() != null
                && deliveryRoute.getStartPoint().equals(deliveryRoute.getEndPoint())) {
            throw new IllegalArgumentException("Start and end points cannot be the same");
        }
        // Add more validation rules as needed
    }
}
