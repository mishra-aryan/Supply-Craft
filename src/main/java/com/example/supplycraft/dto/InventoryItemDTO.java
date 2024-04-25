package com.example.supplycraft.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InventoryItemDTO {
    
    private String sku;
    
    private String name;
    
    private String description;
    
    private int quantity;
    
    private BigDecimal unitPrice;
    
    private String category;
    
    private String manufacturer;
    
    private String location;
    
    private LocalDate expiryDate;
    
    private LocalDateTime lastUpdated;
    
    // Constructors
    
    public InventoryItemDTO() {
    }

    public InventoryItemDTO(String sku, String name, String description, int quantity, BigDecimal unitPrice, String category, String manufacturer, String location, LocalDate expiryDate, LocalDateTime lastUpdated) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.category = category;
        this.manufacturer = manufacturer;
        this.location = location;
        this.expiryDate = expiryDate;
        this.lastUpdated = lastUpdated;
    }

    // Getters and setters
    
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
