package com.acme.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.acme.entity.InventoryItem;
import com.acme.entity.OrderStatus;
import com.acme.entity.TshirtOrder;
import com.acme.exception.TshirtException;
import com.acme.repository.InventoryItemRepository;
import com.acme.repository.TshirtOrderRepository;

@Controller
public class TshirtController {	

	@Autowired
	private InventoryItemRepository inventoryItemRepository;

	@Autowired
	private TshirtOrderRepository tshirtOrderRepository;
	
	@Autowired
	private Validator validator;

	public void setInventoryItemRepository(InventoryItemRepository inventoryItemRepository) {
		this.inventoryItemRepository = inventoryItemRepository;
	}

	public void setTshirtOrderRepository(TshirtOrderRepository tshirtOrderRepository) {
		this.tshirtOrderRepository = tshirtOrderRepository;
	}
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public List<InventoryItem> listInventoryItems() {
		List<com.acme.entity.InventoryItem> inventoryItemsDB = StreamSupport.stream(inventoryItemRepository.findAll().spliterator(), false).collect(Collectors.toList());

		if (inventoryItemsDB == null || inventoryItemsDB.size() == 0) {
			throw new TshirtException("Inventory items not found!");
		}

		return inventoryItemsDB;
	}
	
	@Transactional
	public Long createOrder(TshirtOrder tshirtOrder) {	
		validate(tshirtOrder);
		
		Optional<com.acme.entity.InventoryItem> findById = inventoryItemRepository.findById(tshirtOrder.getProductCode());
		
		if (findById.isPresent()) {
			InventoryItem inventoryItem = findById.get();
			//Verify size
			String orderSize = tshirtOrder.getSize() != null ? tshirtOrder.getSize().value() : null;
			if (inventoryItem.getSize().value().equals(orderSize)) {
				//Verify item availability
				if (inventoryItem.getCount() > 0) {				
					//Set order status
					tshirtOrder.setStatus(OrderStatus.WAITING_CARRIER);
					
					Long orderId = null;
					
					try {
						TshirtOrder save = tshirtOrderRepository.save(tshirtOrder);
						orderId = save.getOrderId();
					} catch (DataIntegrityViolationException e) {
						throw new TshirtException("Duplicate order!");
					}
					
					//Decrease item count					
					inventoryItem.setCount(inventoryItem.getCount() - 1);
					inventoryItemRepository.save(inventoryItem);			
					
					return orderId;
				} else {
					throw new TshirtException("Inventory item: " + tshirtOrder.getProductCode() + " unavailable!");
				}
			} else {
				throw new TshirtException("Product order size is invalid!");
			}		
		} else {
			throw new TshirtException("Inventory item: " + tshirtOrder.getProductCode() + " not found!");
		}
	}
	
	public TshirtOrder trackOrder(Long orderId) {
		Optional<TshirtOrder> findById = tshirtOrderRepository.findById(orderId);
		if (findById.isPresent()) {
			return findById.get();			
		} else {
			throw new TshirtException("Order: " + orderId + " not found!");
		}		
	}
	
	private <T> void validate(T object) {
		Set<ConstraintViolation<Object>> validate = validator.validate(object);
		if (validate.size() > 0) {
			ConstraintViolation<Object> constraintViolation = validate.iterator().next();		
			throw new TshirtException("Bean validation error: " + constraintViolation.getMessage());
		}		
	}
}
