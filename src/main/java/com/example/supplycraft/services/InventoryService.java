package com.example.supplycraft.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.InventoryItem;
import com.example.supplycraft.repositories.InventoryItemRepository;
import com.example.supplycraft.dto.InventoryItemDTO;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class InventoryService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public InventoryItem addInventoryItem(InventoryItemDTO inventoryItemDTO) {
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setSku(inventoryItemDTO.getSku());
        inventoryItem.setName(inventoryItemDTO.getName());
        inventoryItem.setDescription(inventoryItemDTO.getDescription());
        inventoryItem.setQuantity(inventoryItemDTO.getQuantity());
        inventoryItem.setUnitPrice(inventoryItemDTO.getUnitPrice());
        inventoryItem.setCategory(inventoryItemDTO.getCategory());
        inventoryItem.setManufacturer(inventoryItemDTO.getManufacturer());
        inventoryItem.setLocation(inventoryItemDTO.getLocation());
        inventoryItem.setExpiryDate(inventoryItemDTO.getExpiryDate());
        inventoryItem.setLastUpdated(inventoryItemDTO.getLastUpdated());
        // Set other attributes as needed
        return inventoryItemRepository.save(inventoryItem);
    }

    public InventoryItem getInventoryItemById(Long id) {
        return inventoryItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inventory item not found with id: " + id));
    }

    public InventoryItem updateInventoryItem(Long id, InventoryItemDTO inventoryItemDTO) {
        InventoryItem existingInventoryItem = getInventoryItemById(id);
        existingInventoryItem.setSku(inventoryItemDTO.getSku());
        existingInventoryItem.setName(inventoryItemDTO.getName());
        existingInventoryItem.setDescription(inventoryItemDTO.getDescription());
        existingInventoryItem.setQuantity(inventoryItemDTO.getQuantity());
        existingInventoryItem.setUnitPrice(inventoryItemDTO.getUnitPrice());
        existingInventoryItem.setCategory(inventoryItemDTO.getCategory());
        existingInventoryItem.setManufacturer(inventoryItemDTO.getManufacturer());
        existingInventoryItem.setLocation(inventoryItemDTO.getLocation());
        existingInventoryItem.setExpiryDate(inventoryItemDTO.getExpiryDate());
        existingInventoryItem.setLastUpdated(inventoryItemDTO.getLastUpdated());
        // Update other attributes as needed
        return inventoryItemRepository.save(existingInventoryItem);
    }

    public void deleteInventoryItem(Long id) {
        inventoryItemRepository.deleteById(id);
    }
}
