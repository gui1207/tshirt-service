package com.acme.tshirt_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-04-25T13:02:50.699-03:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://mulesoft.org/tshirt-service", name = "TshirtServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TshirtServicePortType {

    @WebMethod(operationName = "TrackOrder", action = "http://mulesoft.org/tshirt-service/track-order")
    @WebResult(name = "TrackOrderResponse", targetNamespace = "http://mulesoft.org/tshirt-service", partName = "body")
    public TrackOrderResponse trackOrder(
        @WebParam(partName = "body", name = "TrackOrder", targetNamespace = "http://mulesoft.org/tshirt-service")
        TrackOrder body
    ) throws TshirtFaultException;

    @WebMethod(operationName = "OrderTshirt", action = "http://mulesoft.org/tshirt-service/order-tshirt")
    @WebResult(name = "OrderTshirtResponse", targetNamespace = "http://mulesoft.org/tshirt-service", partName = "body")
    public OrderTshirtResponse orderTshirt(
        @WebParam(partName = "body", name = "OrderTshirt", targetNamespace = "http://mulesoft.org/tshirt-service")
        OrderTshirt body
    ) throws TshirtFaultException;

    @WebMethod(operationName = "ListInventory", action = "http://mulesoft.org/tshirt-service/list-inventory")
    @WebResult(name = "ListInventoryResponse", targetNamespace = "http://mulesoft.org/tshirt-service", partName = "parameters")
    public ListInventoryResponse listInventory(
        @WebParam(partName = "parameters", name = "ListInventory", targetNamespace = "http://mulesoft.org/tshirt-service")
        ListInventory parameters
    ) throws TshirtFaultException;
}