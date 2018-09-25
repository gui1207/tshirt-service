package com.acme.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.builder.OrderTshirtBuilder;
import com.acme.builder.TrackOrderBuilder;
import com.acme.tshirt_service.InventoryItem;
import com.acme.tshirt_service.ListInventory;
import com.acme.tshirt_service.ListInventoryResponse;
import com.acme.tshirt_service.OrderTshirt;
import com.acme.tshirt_service.OrderTshirtResponse;
import com.acme.tshirt_service.Size;
import com.acme.tshirt_service.Status;
import com.acme.tshirt_service.TrackOrder;
import com.acme.tshirt_service.TrackOrderResponse;
import com.acme.tshirt_service.TshirtFaultException;
import com.acme.tshirt_service.TshirtServicePortType;
import com.acme.tshirt_service.TshirtServicePortTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class TshirtServiceImplIT {
	
	private TshirtServicePortType tshirtServicePortTypePort;	
	
	@Before
	public void setup() {
		tshirtServicePortTypePort = new TshirtServicePortTypeService().getTshirtServicePortTypePort();	
	}
	
	@Test
	public void testListInventory() throws TshirtFaultException {
		ListInventoryResponse listInventoryResponse = tshirtServicePortTypePort.listInventory(new ListInventory());
		
		assertNotNull(listInventoryResponse);
		List<InventoryItem> inventoryItems = listInventoryResponse.getInventory();
				
		assertEquals(4, inventoryItems.size());
		
		Optional<InventoryItem> inventoryItem100 = inventoryItems.stream().filter(i -> i.getProductCode() == 100).findFirst();
		
		// Assert inventory item
		assertTrue(inventoryItem100.isPresent());
		assertEquals(100, inventoryItem100.get().getProductCode());
		assertEquals("T-shirt with logo", inventoryItem100.get().getDescription());
		assertEquals(Size.M, inventoryItem100.get().getSize());
		assertEquals(10, inventoryItem100.get().getCount());		
	}
	
	@Test
	public void orderTshirt() throws TshirtFaultException {		
		OrderTshirt orderTshirt = OrderTshirtBuilder.buildOrderTshirt();
		
		//Create order
		OrderTshirtResponse orderTshirtResponse = tshirtServicePortTypePort.orderTshirt(orderTshirt);
		
		assertNotNull(orderTshirtResponse);
		assertTrue(orderTshirtResponse.getOrderId() > 0);
		
		//Verify order
		TrackOrder trackOrder = new TrackOrder();
		trackOrder.setOrderId(orderTshirtResponse.getOrderId());	
		
		TrackOrderResponse trackOrderResponse = tshirtServicePortTypePort.trackOrder(trackOrder);
		
		assertNotNull(trackOrderResponse);
		assertEquals(trackOrderResponse.getOrderId(), orderTshirtResponse.getOrderId());
		assertEquals(100, trackOrderResponse.getProductCode());
		assertEquals(Size.M, trackOrderResponse.getSize());
		assertEquals(Status.WAITING_CARRIER, trackOrderResponse.getStatus());
		
		//Verify inventory item count
		ListInventoryResponse listInventoryResponse = tshirtServicePortTypePort.listInventory(new ListInventory());
		
		Optional<InventoryItem> inventoryItem100 = listInventoryResponse.getInventory().stream().filter(i -> i.getProductCode() == 100).findFirst();
		assertTrue(inventoryItem100.isPresent());
		assertEquals(9, inventoryItem100.get().getCount());
	}
	
	@Test(expected=TshirtFaultException.class)
	public void orderTshirtInvalidPayload() throws TshirtFaultException {
		tshirtServicePortTypePort.orderTshirt(new OrderTshirt());		
	}
	
	@Test(expected=TshirtFaultException.class)
	public void orderTshirtInvalidItem() throws TshirtFaultException {
		OrderTshirt invalidProduct = OrderTshirtBuilder.buildOrderTshirtInvalidProduct();
		tshirtServicePortTypePort.orderTshirt(invalidProduct);
	}
	
	@Test(expected=TshirtFaultException.class)
	public void testTrackOrderInvalid() throws TshirtFaultException {
		tshirtServicePortTypePort.trackOrder(TrackOrderBuilder.buildTrackOrder(99L));
	}

}
