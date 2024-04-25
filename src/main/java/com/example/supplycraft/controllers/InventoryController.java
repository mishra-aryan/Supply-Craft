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

import com.example.supplycraft.models.InventoryItem;
import com.example.supplycraft.services.InventoryService;
import com.example.supplycraft.dto.InventoryItemDTO;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<?> addInventoryItem(@RequestBody InventoryItemDTO inventoryItemDTO) {
        InventoryItem inventoryItem = inventoryService.addInventoryItem(inventoryItemDTO);
        return ResponseEntity.ok(inventoryItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryItemById(@PathVariable("id") Long id) {
        InventoryItem inventoryItem = inventoryService.getInventoryItemById(id);
        return ResponseEntity.ok(inventoryItem);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateInventoryItem(@PathVariable("id") Long id, @RequestBody InventoryItemDTO inventoryItemDTO) {
        InventoryItem updatedInventoryItem = inventoryService.updateInventoryItem(id, inventoryItemDTO);
        return ResponseEntity.ok(updatedInventoryItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInventoryItem(@PathVariable("id") Long id) {
        inventoryService.deleteInventoryItem(id);
        return ResponseEntity.ok("Inventory item deleted successfully");
    }
}