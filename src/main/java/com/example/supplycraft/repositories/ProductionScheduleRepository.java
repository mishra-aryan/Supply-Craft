package com.example.supplycraft.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supplycraft.models.Product;
import com.example.supplycraft.models.ProductionSchedule;
import com.example.supplycraft.models.ProductionScheduleStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductionScheduleRepository extends JpaRepository<ProductionSchedule, Long> {

    // Find production schedules by production date
    List<ProductionSchedule> findByProductionDate(LocalDate productionDate);

    // Find production schedules by shift
    List<ProductionSchedule> findByShift(String shift);

    // Find production schedules by product
    List<ProductionSchedule> findByProduct(Product product);

    // Find production schedules by quantity
    List<ProductionSchedule> findByQuantity(int quantity);

    // Find production schedules by production line
    List<ProductionSchedule> findByProductionLine(String productionLine);

    // Find production schedules by status
    List<ProductionSchedule> findByStatus(ProductionScheduleStatus status);

    // Find production schedules by lead time
    List<ProductionSchedule> findByLeadTime(int leadTime);

    // Find production schedules by planned start time
    List<ProductionSchedule> findByPlannedStartTime(LocalDateTime plannedStartTime);

    // Find production schedules by planned end time
    List<ProductionSchedule> findByPlannedEndTime(LocalDateTime plannedEndTime);

    // Find production schedules by actual start time
    List<ProductionSchedule> findByActualStartTime(LocalDateTime actualStartTime);

    // Find production schedules by actual end time
    List<ProductionSchedule> findByActualEndTime(LocalDateTime actualEndTime);
}
