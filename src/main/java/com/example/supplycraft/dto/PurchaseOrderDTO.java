package com.example.supplycraft.dto;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.supplycraft.models.PurchaseOrderStatus;

public class PurchaseOrderDTO {
    
    private String orderNumber;
    
    private LocalDate orderDate;
    
    private LocalDate dueDate;
    
    private BigDecimal totalAmount;
    
    private PurchaseOrderStatus status;

    // Constructors
    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(String orderNumber, LocalDate orderDate, LocalDate dueDate, BigDecimal totalAmount, PurchaseOrderStatus status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and setters
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PurchaseOrderStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseOrderStatus status) {
        this.status = status;
    }
}
