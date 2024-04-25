package com.example.supplycraft.services;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.PurchaseOrder;
import com.example.supplycraft.repositories.PurchaseOrderRepository;

import com.example.supplycraft.dto.PurchaseOrderDTO;

@Service
public class PurchaseOrderService {
	
	
	@Autowired
	public PurchaseOrderRepository purchaseOrderRepository;
	
	
	public PurchaseOrder createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		purchaseOrder.setOrderNumber(purchaseOrderDTO.getOrderNumber());
		purchaseOrder.setOrderDate(purchaseOrderDTO.getOrderDate());
		purchaseOrder.setDueDate(purchaseOrderDTO.getDueDate());
		purchaseOrder.setTotalAmount(purchaseOrderDTO.getTotalAmount());
		purchaseOrder.setStatus(purchaseOrderDTO.getStatus());
		
		return purchaseOrderRepository.save(purchaseOrder);
		
	}
	
	public PurchaseOrder getPurchaseOrderById(Long id) {
		return purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Purchase order not found with id: " + id));
	}
	
	public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrderDTO updatedPurchaseOrderDTO) {
		
		PurchaseOrder existingPurchaseOrder = purchaseOrderRepository.findPurchaseOrderById(id);
		
		existingPurchaseOrder.setOrderNumber(updatedPurchaseOrderDTO.getOrderNumber());
		existingPurchaseOrder.setOrderDate(updatedPurchaseOrderDTO.getDueDate());
		existingPurchaseOrder.setDueDate(updatedPurchaseOrderDTO.getDueDate());
		existingPurchaseOrder.setTotalAmount(updatedPurchaseOrderDTO.getTotalAmount());
		existingPurchaseOrder.setStatus(updatedPurchaseOrderDTO.getStatus());
		
		return purchaseOrderRepository.save(existingPurchaseOrder);
	}
	
	public void deletePurchaseOrder(Long id) {
		purchaseOrderRepository.deleteById(id);
	}

}
