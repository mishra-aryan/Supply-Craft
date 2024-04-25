package com.example.supplycraft.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.Supplier;
import com.example.supplycraft.repositories.SupplierRepository;
import com.example.supplycraft.dto.SupplierDTO;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + id));
    }

    public Supplier createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = convertToEntity(supplierDTO);
        // Add any validation or business logic here
        return supplierRepository.save(supplier);
    }

    private Supplier convertToEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierDTO, supplier);
        // Additional mapping if needed
        return supplier;
    }
    public Supplier updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier existingSupplier = getSupplierById(id);
        // Update existingSupplier with fields from updatedSupplier
        existingSupplier.setCompanyName(supplierDTO.getCompanyName());
        // Add any other fields to update
        // Add any validation or business logic here
        return supplierRepository.save(existingSupplier);
    }

    public void deleteSupplier(Long id) {
        Supplier existingSupplier = getSupplierById(id);
        supplierRepository.delete(existingSupplier);
    }
}

