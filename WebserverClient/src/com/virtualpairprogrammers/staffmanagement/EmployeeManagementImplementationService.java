
package com.virtualpairprogrammers.staffmanagement;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EmployeeManagementImplementationService", targetNamespace = "http://staffmanagement.virtualpairprogrammers.com/", wsdlLocation = "http://localhost:8080/EmployeeManagementImplementationService/employeeManagementWebService?wsdl")
public class EmployeeManagementImplementationService
    extends Service
{

    private final static URL EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_EXCEPTION;
    private final static QName EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_QNAME = new QName("http://staffmanagement.virtualpairprogrammers.com/", "EmployeeManagementImplementationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/EmployeeManagementImplementationService/employeeManagementWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_WSDL_LOCATION = url;
        EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_EXCEPTION = e;
    }

    public EmployeeManagementImplementationService() {
        super(__getWsdlLocation(), EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_QNAME);
    }

    public EmployeeManagementImplementationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public EmployeeManagementImplementationService(URL wsdlLocation) {
        super(wsdlLocation, EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_QNAME);
    }

    public EmployeeManagementImplementationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public EmployeeManagementImplementationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeManagementImplementationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmployeeManagementWebService
     */
    @WebEndpoint(name = "employeeManagementWebServicePort")
    public EmployeeManagementWebService getEmployeeManagementWebServicePort() {
        return super.getPort(new QName("http://staffmanagement.virtualpairprogrammers.com/", "employeeManagementWebServicePort"), EmployeeManagementWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeManagementWebService
     */
    @WebEndpoint(name = "employeeManagementWebServicePort")
    public EmployeeManagementWebService getEmployeeManagementWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://staffmanagement.virtualpairprogrammers.com/", "employeeManagementWebServicePort"), EmployeeManagementWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_EXCEPTION!= null) {
            throw EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_EXCEPTION;
        }
        return EMPLOYEEMANAGEMENTIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    }

}
