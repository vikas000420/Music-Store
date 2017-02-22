/**
 * CDCatalogServiceImplPortBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class CDCatalogServiceImplPortBindingSkeleton implements com.musicstore.ws.CDCatalogService, org.apache.axis.wsdl.Skeleton {
    private com.musicstore.ws.CDCatalogService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "category"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getProductList", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "products"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "getProductList"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProductList") == null) {
            _myOperations.put("getProductList", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProductList")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getCategoryList", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "categories"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "getCategoryList"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCategoryList") == null) {
            _myOperations.put("getCategoryList", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getCategoryList")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cdid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getProductInfo", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "cd"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "getProductInfo"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProductInfo") == null) {
            _myOperations.put("getProductInfo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProductInfo")).add(_oper);
    }

    public CDCatalogServiceImplPortBindingSkeleton() {
        this.impl = new com.musicstore.ws.CDCatalogServiceImplPortBindingImpl();
    }

    public CDCatalogServiceImplPortBindingSkeleton(com.musicstore.ws.CDCatalogService impl) {
        this.impl = impl;
    }
    public com.musicstore.ws.Cd[] getProductList(java.lang.String category) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Cd[] ret = impl.getProductList(category);
        return ret;
    }

    public java.lang.String[] getCategoryList() throws java.rmi.RemoteException
    {
        java.lang.String[] ret = impl.getCategoryList();
        return ret;
    }

    public com.musicstore.ws.Cd getProductInfo(java.lang.String cdid) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Cd ret = impl.getProductInfo(cdid);
        return ret;
    }

}
