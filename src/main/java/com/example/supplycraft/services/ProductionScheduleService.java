package com.example.supplycraft.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.ProductionSchedule;
import com.example.supplycraft.repositories.ProductionScheduleRepository;
import com.example.supplycraft.dto.ProductionScheduleDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductionScheduleService {

    @Autowired
    private ProductionScheduleRepository productionScheduleRepository;

    public List<ProductionSchedule> getAllProductionSchedules() {
        return productionScheduleRepository.findAll();
    }

    public ProductionSchedule getProductionScheduleById(Long id) {
        return productionScheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProductionSchedule not found with id: " + id));
    }

    public ProductionSchedule createProductionSchedule(ProductionScheduleDTO productionScheduleDTO) {
        ProductionSchedule productionSchedule = new ProductionSchedule();
        // Set attributes from DTO
        productionSchedule.setProductionDate(productionScheduleDTO.getProductionDate());
        productionSchedule.setShift(productionScheduleDTO.getShift());
        // Set other attributes...

        // Validate the production schedule
        validateProductionSchedule(productionSchedule);

        // Save the production schedule
        return productionScheduleRepository.save(productionSchedule);
    }

    public ProductionSchedule updateProductionSchedule(Long id, ProductionScheduleDTO productionScheduleDTO) {
        ProductionSchedule existingProductionSchedule = getProductionScheduleById(id);

        // Update attributes from DTO
        existingProductionSchedule.setProductionDate(productionScheduleDTO.getProductionDate());
        existingProductionSchedule.setShift(productionScheduleDTO.getShift());
        // Update other attributes...

        // Validate the updated production schedule
        validateProductionSchedule(existingProductionSchedule);

        // Save the updated production schedule
        return productionScheduleRepository.save(existingProductionSchedule);
    }

    public void deleteProductionSchedule(Long id) {
        ProductionSchedule existingProductionSchedule = getProductionScheduleById(id);
        productionScheduleRepository.delete(existingProductionSchedule);
    }

    private void validateProductionSchedule(ProductionSchedule productionSchedule) {
        // Add validation logic here
        // For example, ensure production date is in the future
        if (productionSchedule.getProductionDate() != null && productionSchedule.getProductionDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Production date must be in the future");
        }
        // Add more validation rules as needed
    }
}
