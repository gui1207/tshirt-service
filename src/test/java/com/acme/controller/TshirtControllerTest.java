package com.acme.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;

import com.acme.builder.InventoryItemBuild;
import com.acme.builder.TshirtOrderBuilder;
import com.acme.controller.TshirtController;
import com.acme.entity.InventoryItem;
import com.acme.entity.OrderStatus;
import com.acme.entity.TshirtOrder;
import com.acme.entity.TshirtSize;
import com.acme.exception.TshirtException;
import com.acme.repository.InventoryItemRepository;
import com.acme.repository.TshirtOrderRepository;

@RunWith(MockitoJUnitRunner.class)
public class TshirtControllerTest {

	private TshirtController tshirtController;
	@Mock
	private InventoryItemRepository inventoryItemRepository;
	@Mock
	private TshirtOrderRepository tshirtOrderRepository;

	@Before
	public void setup() {		
		tshirtController = new TshirtController();
		tshirtController.setInventoryItemRepository(inventoryItemRepository);
		tshirtController.setTshirtOrderRepository(tshirtOrderRepository);
		tshirtController.setValidator(Validation.buildDefaultValidatorFactory().getValidator());		
	}

	@Test
	public void testListInventoryItems() {
		when(inventoryItemRepository.findAll()).thenReturn(InventoryItemBuild.buildInventoryItems());

		List<InventoryItem> inventoryItems = tshirtController.listInventoryItems();

		assertEquals(2, inventoryItems.size());

		Optional<InventoryItem> inventoryItem9001 = inventoryItems.stream().filter(i -> i.getProductCode() == 9001).findFirst();
		// Assert inventory item
		assertTrue(inventoryItem9001.isPresent());
		assertEquals(9001, inventoryItem9001.get().getProductCode());		
		assertEquals("T-shirt with medium logo", inventoryItem9001.get().getDescription());
		assertEquals(TshirtSize.M, inventoryItem9001.get().getSize());
		assertEquals(10, inventoryItem9001.get().getCount());

		// Assert inventory item
		Optional<InventoryItem> inventoryItem9002 = inventoryItems.stream().filter(i -> i.getProductCode() == 9002).findFirst();
		assertTrue(inventoryItem9002.isPresent());
		assertEquals(9002, inventoryItem9002.get().getProductCode());		
		assertEquals("T-shirt with medium logo", inventoryItem9002.get().getDescription());
		assertEquals(TshirtSize.L, inventoryItem9002.get().getSize());
		assertEquals(8, inventoryItem9002.get().getCount());
	}
	
	@Test
	public void testListInventoryItemsEmpty() {
		when(inventoryItemRepository.findAll()).thenReturn(new ArrayList<>());
		
		try {
			tshirtController.listInventoryItems();
			fail("Exception expected");
		} catch (Exception e) {
			assertTrue(e instanceof TshirtException);
			assertEquals("Inventory items not found!", e.getMessage());
		}		
	}

	@Test
	public void testCreateOrder() {
		InventoryItem inventoryItem1 = spy(InventoryItemBuild.buildInventoryItem1());
		TshirtOrder tshirtOrder = spy(TshirtOrderBuilder.build());

		when(inventoryItemRepository.findById(tshirtOrder.getProductCode())).thenReturn(Optional.of(inventoryItem1));
		when(tshirtOrderRepository.save(tshirtOrder)).thenReturn(tshirtOrder);
		when(inventoryItemRepository.save(inventoryItem1)).thenReturn(inventoryItem1);

		// Verify count before createOrder
		assertEquals(10, inventoryItem1.getCount());

		// Create order
		Long order = tshirtController.createOrder(tshirtOrder);

		// Assert order
		assertEquals(Long.valueOf(1), order);
		verify(tshirtOrder).setStatus(OrderStatus.WAITING_CARRIER);
		assertEquals(OrderStatus.WAITING_CARRIER, tshirtOrder.getStatus());

		// Assert count after create order
		verify(inventoryItem1).setCount(9);
		assertEquals(9, inventoryItem1.getCount());
	}
	
	@Test
	public void testCreateOrderInvalidProduct() {
		TshirtOrder tshirtOrder = TshirtOrderBuilder.buildInvalidProduct();
		when(inventoryItemRepository.findById(tshirtOrder.getProductCode())).thenReturn(Optional.empty());
		
		try {
			tshirtController.createOrder(tshirtOrder);
			fail("Exception expected");
		} catch (Exception e) {
			assertTrue(e instanceof TshirtException);
			assertEquals("Inventory item: " + tshirtOrder.getProductCode() + " not found!", e.getMessage());
		}		
	}
	
	@Test
	public void testCreateOrderInvalidSize() {
		InventoryItem inventoryItem = InventoryItemBuild.buildInventoryItem1();
		TshirtOrder tshirtOrder = TshirtOrderBuilder.build();
		//change tshirt order size
		tshirtOrder.setSize(TshirtSize.XXL);
		
		when(inventoryItemRepository.findById(tshirtOrder.getProductCode())).thenReturn(Optional.of(inventoryItem));
		
		try {
			tshirtController.createOrder(tshirtOrder);
			fail("Exception expected");
		} catch (Exception e) {			
			assertTrue(e instanceof TshirtException);
			assertEquals("Product order size is invalid!", e.getMessage());
		}		
	}
	
	@Test
	public void testCreateOrderUnavailableItem() {
		InventoryItem inventoryItemUnavailable = InventoryItemBuild.buildInventoryItemUnavailable();
		TshirtOrder tshirtOrder = TshirtOrderBuilder.build();
		
		when(inventoryItemRepository.findById(tshirtOrder.getProductCode())).thenReturn(Optional.of(inventoryItemUnavailable));
		
		try {
			tshirtController.createOrder(tshirtOrder);
			fail("Exception expected");
		} catch (Exception e) {
			assertTrue(e instanceof TshirtException);
			assertEquals("Inventory item: " + tshirtOrder.getProductCode() + " unavailable!", e.getMessage());
		}		
	}
	
	@Test
	public void testCreateOrderDuplicate() {
		InventoryItem inventoryItem1 = spy(InventoryItemBuild.buildInventoryItem1());
		TshirtOrder tshirtOrder = TshirtOrderBuilder.build();
		
		when(inventoryItemRepository.findById(tshirtOrder.getProductCode())).thenReturn(Optional.of(inventoryItem1));
		when(tshirtOrderRepository.save(tshirtOrder)).thenThrow(new DataIntegrityViolationException("duplicate"));
		
		try {
			tshirtController.createOrder(tshirtOrder);
			fail("Exception expected");
		} catch (Exception e) {			
			assertTrue(e instanceof TshirtException);
			assertEquals("Duplicate order!", e.getMessage());
		}
	}

	@Test
	public void testTrackOrder() {
		TshirtOrder tshirtOrder = TshirtOrderBuilder.buildTrackOrder();

		when(tshirtOrderRepository.findById(tshirtOrder.getOrderId())).thenReturn(Optional.of(tshirtOrder));
		
		TshirtOrder trackOrder = tshirtController.trackOrder(tshirtOrder.getOrderId());
		
		assertEquals(Long.valueOf(1), trackOrder.getOrderId());
		assertEquals(OrderStatus.WAITING_CARRIER, trackOrder.getStatus());
	}
	
	@Test
	public void testTrackOrderInvalid() {
		TshirtOrder tshirtOrder = TshirtOrderBuilder.buildTrackOrder();
		when(tshirtOrderRepository.findById(tshirtOrder.getOrderId())).thenReturn(Optional.empty());
		
		try {
			tshirtController.trackOrder(tshirtOrder.getOrderId());
			fail("Exception expected");
		} catch (Exception e) {
			assertTrue(e instanceof TshirtException);
			assertEquals("Order: " + tshirtOrder.getOrderId() + " not found!", e.getMessage());
		}		
	}
}
