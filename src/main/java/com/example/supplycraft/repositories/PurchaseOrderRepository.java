package com.example.supplycraft.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supplycraft.models.PurchaseOrder;
import com.example.supplycraft.models.PurchaseOrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    // Find purchase orders by order number
    PurchaseOrder findByOrderNumber(String orderNumber);

    // Find purchase orders by status
    List<PurchaseOrder> findByStatus(PurchaseOrderStatus status);

    // Find purchase orders by order date between start date and end date
    List<PurchaseOrder> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

    // Find purchase orders by due date before specified date
    List<PurchaseOrder> findByDueDateBefore(LocalDate date);

    // Find purchase orders by total amount greater than specified amount
    List<PurchaseOrder> findByTotalAmountGreaterThan(BigDecimal amount);

    // Find purchase orders by total amount less than specified amount
    List<PurchaseOrder> findByTotalAmountLessThan(BigDecimal amount);

    // Find purchase orders by total amount between specified amounts
    List<PurchaseOrder> findByTotalAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);

	PurchaseOrder findPurchaseOrderById(Long id);
}
