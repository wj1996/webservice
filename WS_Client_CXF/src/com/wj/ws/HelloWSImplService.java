package com.wj.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-08-26T13:59:22.409+08:00
 * Generated source version: 3.2.6
 *
 */
@WebServiceClient(name = "HelloWSImplService",
                  wsdlLocation = "file:/G:/workspace1/eclipse-commit/WS_Client_CXF/src/test.wsdl",
                  targetNamespace = "http://ws.wj.com/")
public class HelloWSImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.wj.com/", "HelloWSImplService");
    public final static QName HelloWSImplPort = new QName("http://ws.wj.com/", "HelloWSImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/G:/workspace1/eclipse-commit/WS_Client_CXF/src/test.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HelloWSImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/G:/workspace1/eclipse-commit/WS_Client_CXF/src/test.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HelloWSImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HelloWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWSImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public HelloWSImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HelloWSImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HelloWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSImplPort")
    public HelloWS getHelloWSImplPort() {
        return super.getPort(HelloWSImplPort, HelloWS.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSImplPort")
    public HelloWS getHelloWSImplPort(WebServiceFeature... features) {
        return super.getPort(HelloWSImplPort, HelloWS.class, features);
    }

}
