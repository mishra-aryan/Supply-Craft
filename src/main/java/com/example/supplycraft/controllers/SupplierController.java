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

import com.example.supplycraft.models.Supplier;
import com.example.supplycraft.services.SupplierService;
import com.example.supplycraft.dto.SupplierDTO;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<?> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        Supplier supplier = supplierService.createSupplier(supplierDTO);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable("id") Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable("id") Long id, @RequestBody SupplierDTO supplierDTO) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplierDTO);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable("id") Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }
}
