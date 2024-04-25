package com.example.supplycraft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supplycraft.models.InventoryItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    // Find inventory items by SKU
    List<InventoryItem> findBySku(String sku);

    // Find inventory items by name
    List<InventoryItem> findByName(String name);

    // Find inventory items by description
    List<InventoryItem> findByDescription(String description);

    // Find inventory items by quantity
    List<InventoryItem> findByQuantity(int quantity);

    // Find inventory items by unit price
    List<InventoryItem> findByUnitPrice(BigDecimal unitPrice);

    // Find inventory items by category
    List<InventoryItem> findByCategory(String category);

    // Find inventory items by manufacturer
    List<InventoryItem> findByManufacturer(String manufacturer);

    // Find inventory items by location
    List<InventoryItem> findByLocation(String location);

    // Find inventory items by expiry date
    List<InventoryItem> findByExpiryDate(LocalDate expiryDate);

    // Find inventory items by last updated time
    List<InventoryItem> findByLastUpdated(LocalDateTime lastUpdated);
}
