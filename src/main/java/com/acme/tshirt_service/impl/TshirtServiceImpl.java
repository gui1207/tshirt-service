package com.acme.tshirt_service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acme.controller.TshirtController;
import com.acme.entity.CardEntity;
import com.acme.entity.CustomerEntity;
import com.acme.entity.TshirtOrder;
import com.acme.exception.TshirtFaultExceptionBuilder;
import com.acme.tshirt_service.CardId;
import com.acme.tshirt_service.Cards;
import com.acme.tshirt_service.Customer;
import com.acme.tshirt_service.CustomerId;
import com.acme.tshirt_service.InventoryItem;
import com.acme.tshirt_service.ListInventory;
import com.acme.tshirt_service.ListInventoryResponse;
import com.acme.tshirt_service.OrderTshirt;
import com.acme.tshirt_service.OrderTshirtResponse;
import com.acme.tshirt_service.TrackOrder;
import com.acme.tshirt_service.TrackOrderResponse;
import com.acme.tshirt_service.TshirtFaultException;
import com.acme.tshirt_service.TshirtServicePortType;

@javax.jws.WebService(serviceName = "TshirtServicePortTypeService", portName = "TshirtServicePortTypePort", targetNamespace = "http://acme.com/tshirt-service", wsdlLocation = "classpath:wsdl/tshirt-service.wsdl", endpointInterface = "com.acme.tshirt_service.TshirtServicePortType")
@Service
public class TshirtServiceImpl implements TshirtServicePortType {

	private static final Logger LOGGER = Logger.getLogger(TshirtServiceImpl.class.getName());

	@Autowired
	private TshirtController tshirtController;
	
	private ModelMapper modelMapper = new ModelMapper();	

	public void setTshirtController(TshirtController tshirtController) {
		this.tshirtController = tshirtController;
	}
	

	public TrackOrderResponse trackOrder(TrackOrder body) throws TshirtFaultException {
		LOGGER.info("Executing operation trackOrder");
		
		try {
			TshirtOrder trackOrder = tshirtController.trackOrder(Long.valueOf(body.getOrderId()));

			return modelMapper.map(trackOrder, TrackOrderResponse.class);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "trackOrder exception", e);
			throw TshirtFaultExceptionBuilder.buildException(e);
		}	
	}

	public OrderTshirtResponse orderTshirt(OrderTshirt body) throws TshirtFaultException {
		LOGGER.info("Executing operation orderTshirt");
		try {
			TshirtOrder tshirtOrder = modelMapper.map(body, com.acme.entity.TshirtOrder.class);
			Long order = tshirtController.createOrder(tshirtOrder);

			OrderTshirtResponse orderTshirtResponse = new OrderTshirtResponse();
			orderTshirtResponse.setOrderId(order);

			return orderTshirtResponse;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "orderTshirt exception", e);			
			throw TshirtFaultExceptionBuilder.buildException(e);
		}		
	}

	public ListInventoryResponse listInventory(ListInventory parameters) throws TshirtFaultException {
		LOGGER.info("Executing operation listInventory");
		try {
			ListInventoryResponse listInventoryResponse = new ListInventoryResponse();

			List<InventoryItem> inventoryList = modelMapper.map(tshirtController.listInventoryItems(), new TypeToken<List<InventoryItem>>() {}.getType());

			listInventoryResponse.getInventory().addAll(inventoryList);

			return listInventoryResponse;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "listInventory exception", e);
			throw TshirtFaultExceptionBuilder.buildException(e);
		}		
	}

	@Override
	public Cards getCard(CardId body) throws TshirtFaultException {
		try {
			Cards cards = new Cards();
			cards = tshirtController.getCard(body);
			return cards;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "orderTshirt exception", e);
			throw TshirtFaultExceptionBuilder.buildException(e);
		}
		
	}
	
	
	public CustomerId createCustomer(Customer body) throws TshirtFaultException{
        LOGGER.info("Executing operation createCustomer");
        
        try {
            CustomerEntity customerEntity = modelMapper.map(body, com.acme.entity.CustomerEntity.class);
            int customerId = tshirtController.createCustomer(customerEntity);
            CustomerId customerIdResponse = new CustomerId();
            customerIdResponse.setCustomerId(customerId);
            return customerIdResponse;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "orderTshirt exception", e);            
            throw TshirtFaultExceptionBuilder.buildException(e);
        }

    }

	@Override
	public CustomerId updateCustomer(Customer body) throws TshirtFaultException {
		try {
            CustomerEntity customerEntity = modelMapper.map(body, com.acme.entity.CustomerEntity.class);
            int customerId = tshirtController.updateCustomer(customerEntity);
            CustomerId customerIdResponse = new CustomerId();
            customerIdResponse.setCustomerId(customerId);
            return customerIdResponse;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "orderTshirt exception", e);            
            throw TshirtFaultExceptionBuilder.buildException(e);
        }
	}

	@Override
	public Customer getCustomer(CustomerId body) throws TshirtFaultException {
		try {
			Customer customer = new Customer();
			customer = tshirtController.getCustomer(body);
			return customer;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "orderTshirt exception", e);
			throw TshirtFaultExceptionBuilder.buildException(e);
		}
		
	}

	@Override
	public CardId updateCard(Cards body) throws TshirtFaultException {
		try {
            CardEntity cardEntity = modelMapper.map(body, com.acme.entity.CardEntity.class);
            int cardId = tshirtController.updateCard(cardEntity);
            CardId cardIdResponse = new CardId();
            cardIdResponse.setCardId(cardId);
            return cardIdResponse;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "orderTshirt exception", e);            
            throw TshirtFaultExceptionBuilder.buildException(e);
        }
	}
	

	@Override
	public CardId createCard(Cards body) throws TshirtFaultException {
		LOGGER.info("Executing operation createCard");
        
        try {
            CardEntity cardEntity = modelMapper.map(body, com.acme.entity.CardEntity.class);
            int cardId = tshirtController.createCard(cardEntity);
            CardId cardIdResponse = new CardId();
            cardIdResponse.setCardId(cardId);
            return cardIdResponse;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "orderTshirt exception", e);            
            throw TshirtFaultExceptionBuilder.buildException(e);
        }

    }
	

}
