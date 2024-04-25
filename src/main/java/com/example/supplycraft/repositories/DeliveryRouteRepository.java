package com.example.supplycraft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supplycraft.models.DeliveryRoute;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeliveryRouteRepository extends JpaRepository<DeliveryRoute, Long> {

    // Find delivery routes by route number
    List<DeliveryRoute> findByRouteNumber(String routeNumber);

    // Find delivery routes by start point
    List<DeliveryRoute> findByStartPoint(String startPoint);

    // Find delivery routes by end point
    List<DeliveryRoute> findByEndPoint(String endPoint);

    // Find delivery routes by start date
    List<DeliveryRoute> findByStartDate(LocalDate startDate);

    // Find delivery routes by end date
    List<DeliveryRoute> findByEndDate(LocalDate endDate);

    // Find delivery routes by distance
    List<DeliveryRoute> findByDistance(int distance);

    // Find delivery routes by estimated duration
    List<DeliveryRoute> findByEstimatedDuration(int estimatedDuration);
}
