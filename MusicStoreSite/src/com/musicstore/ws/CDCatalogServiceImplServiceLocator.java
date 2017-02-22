/**
 * CDCatalogServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class CDCatalogServiceImplServiceLocator extends org.apache.axis.client.Service implements com.musicstore.ws.CDCatalogServiceImplService {

    public CDCatalogServiceImplServiceLocator() {
    }


    public CDCatalogServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CDCatalogServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CDCatalogServiceImplPort
    private java.lang.String CDCatalogServiceImplPort_address = "https://localhost:8443/MusicStore/CDWebService";

    public java.lang.String getCDCatalogServiceImplPortAddress() {
        return CDCatalogServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CDCatalogServiceImplPortWSDDServiceName = "CDCatalogServiceImplPort";

    public java.lang.String getCDCatalogServiceImplPortWSDDServiceName() {
        return CDCatalogServiceImplPortWSDDServiceName;
    }

    public void setCDCatalogServiceImplPortWSDDServiceName(java.lang.String name) {
        CDCatalogServiceImplPortWSDDServiceName = name;
    }

    public com.musicstore.ws.CDCatalogService getCDCatalogServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CDCatalogServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCDCatalogServiceImplPort(endpoint);
    }

    public com.musicstore.ws.CDCatalogService getCDCatalogServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.musicstore.ws.CDCatalogServiceImplPortBindingStub _stub = new com.musicstore.ws.CDCatalogServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getCDCatalogServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCDCatalogServiceImplPortEndpointAddress(java.lang.String address) {
        CDCatalogServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.musicstore.ws.CDCatalogService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.musicstore.ws.CDCatalogServiceImplPortBindingStub _stub = new com.musicstore.ws.CDCatalogServiceImplPortBindingStub(new java.net.URL(CDCatalogServiceImplPort_address), this);
                _stub.setPortName(getCDCatalogServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CDCatalogServiceImplPort".equals(inputPortName)) {
            return getCDCatalogServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.musicstore.com/", "CDCatalogServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.musicstore.com/", "CDCatalogServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CDCatalogServiceImplPort".equals(portName)) {
            setCDCatalogServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
