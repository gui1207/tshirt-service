package com.acme.tshirt_service;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2020-04-06T11:54:26.140-03:00
 * Generated source version: 3.3.2
 *
 */
@WebServiceClient(name = "TshirtServicePortTypeService",
                  wsdlLocation = "classpath:wsdl/tshirt-service.wsdl",
                  targetNamespace = "http://acme.com/tshirt-service")
public class TshirtServicePortTypeService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://acme.com/tshirt-service", "TshirtServicePortTypeService");
    public final static QName TshirtServicePortTypePort = new QName("http://acme.com/tshirt-service", "TshirtServicePortTypePort");
    static {
        URL url = TshirtServicePortTypeService.class.getClassLoader().getResource("wsdl/tshirt-service.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(TshirtServicePortTypeService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/tshirt-service.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TshirtServicePortTypeService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TshirtServicePortTypeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TshirtServicePortTypeService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TshirtServicePortTypeService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TshirtServicePortTypeService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TshirtServicePortTypeService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TshirtServicePortType
     */
    @WebEndpoint(name = "TshirtServicePortTypePort")
    public TshirtServicePortType getTshirtServicePortTypePort() {
        return super.getPort(TshirtServicePortTypePort, TshirtServicePortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TshirtServicePortType
     */
    @WebEndpoint(name = "TshirtServicePortTypePort")
    public TshirtServicePortType getTshirtServicePortTypePort(WebServiceFeature... features) {
        return super.getPort(TshirtServicePortTypePort, TshirtServicePortType.class, features);
    }

}
