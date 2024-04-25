package com.example.supplycraft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supplycraft.models.Supplier;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    
    // Find supplier by company name
    Optional<Supplier> findByCompanyName(String companyName);
    
    // Find supplier by email
    Optional<Supplier> findByEmail(String email);
    
    // Find supplier by id
    Optional<Supplier> findById(Long id);
    
    // Save or update supplier
    @SuppressWarnings("unchecked")
	Supplier save(Supplier supplier);
    
    // Delete supplier by id
    void deleteById(Long id);
    
}
