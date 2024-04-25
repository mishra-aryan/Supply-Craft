package com.example.supplycraft.dto;

import java.time.LocalDate;

public class DeliveryRouteDTO {

    private String routeNumber;
    private String startPoint;
    private String endPoint;
    private LocalDate startDate;
    private LocalDate endDate;
    private int distance;
    private int estimatedDuration;

    // Constructors
    public DeliveryRouteDTO() {
    }

    public DeliveryRouteDTO(String routeNumber, String startPoint, String endPoint, LocalDate startDate, LocalDate endDate, int distance, int estimatedDuration) {
        this.routeNumber = routeNumber;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
        this.estimatedDuration = estimatedDuration;
    }

    // Getters and setters
    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }
}
