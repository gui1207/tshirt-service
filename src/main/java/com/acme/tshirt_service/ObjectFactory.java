
package com.acme.tshirt_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.acme.tshirt_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.acme.tshirt_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListInventory }
     * 
     */
    public ListInventory createListInventory() {
        return new ListInventory();
    }

    /**
     * Create an instance of {@link ListInventoryResponse }
     * 
     */
    public ListInventoryResponse createListInventoryResponse() {
        return new ListInventoryResponse();
    }

    /**
     * Create an instance of {@link InventoryItem }
     * 
     */
    public InventoryItem createInventoryItem() {
        return new InventoryItem();
    }

    /**
     * Create an instance of {@link OrderTshirt }
     * 
     */
    public OrderTshirt createOrderTshirt() {
        return new OrderTshirt();
    }

    /**
     * Create an instance of {@link OrderTshirtResponse }
     * 
     */
    public OrderTshirtResponse createOrderTshirtResponse() {
        return new OrderTshirtResponse();
    }

    /**
     * Create an instance of {@link TrackOrder }
     * 
     */
    public TrackOrder createTrackOrder() {
        return new TrackOrder();
    }

    /**
     * Create an instance of {@link TrackOrderResponse }
     * 
     */
    public TrackOrderResponse createTrackOrderResponse() {
        return new TrackOrderResponse();
    }

    /**
     * Create an instance of {@link TshirtFault }
     * 
     */
    public TshirtFault createTshirtFault() {
        return new TshirtFault();
    }

}
