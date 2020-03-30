
package com.acme.tshirt_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    private final static QName _CreateCustomer_QNAME = new QName("http://acme.com/tshirt-service", "CreateCustomer");
    private final static QName _UpdateCustomer_QNAME = new QName("http://acme.com/tshirt-service", "UpdateCustomer");
    private final static QName _CreateCard_QNAME = new QName("http://acme.com/tshirt-service", "CreateCard");
    private final static QName _UpdateCard_QNAME = new QName("http://acme.com/tshirt-service", "UpdateCard");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.acme.tshirt_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link CustomerId }
     * 
     */
    public CustomerId createCustomerId() {
        return new CustomerId();
    }

    /**
     * Create an instance of {@link Cards }
     * 
     */
    public Cards createCards() {
        return new Cards();
    }

    /**
     * Create an instance of {@link CardId }
     * 
     */
    public CardId createCardId() {
        return new CardId();
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     */
    @XmlElementDecl(namespace = "http://acme.com/tshirt-service", name = "CreateCustomer")
    public JAXBElement<Customer> createCreateCustomer(Customer value) {
        return new JAXBElement<Customer>(_CreateCustomer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     */
    @XmlElementDecl(namespace = "http://acme.com/tshirt-service", name = "UpdateCustomer")
    public JAXBElement<Customer> createUpdateCustomer(Customer value) {
        return new JAXBElement<Customer>(_UpdateCustomer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cards }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Cards }{@code >}
     */
    @XmlElementDecl(namespace = "http://acme.com/tshirt-service", name = "CreateCard")
    public JAXBElement<Cards> createCreateCard(Cards value) {
        return new JAXBElement<Cards>(_CreateCard_QNAME, Cards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cards }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Cards }{@code >}
     */
    @XmlElementDecl(namespace = "http://acme.com/tshirt-service", name = "UpdateCard")
    public JAXBElement<Cards> createUpdateCard(Cards value) {
        return new JAXBElement<Cards>(_UpdateCard_QNAME, Cards.class, null, value);
    }

}
