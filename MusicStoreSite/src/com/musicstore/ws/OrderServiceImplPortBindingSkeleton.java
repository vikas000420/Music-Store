/**
 * OrderServiceImplPortBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public class OrderServiceImplPortBindingSkeleton implements com.musicstore.ws.OrderService, org.apache.axis.wsdl.Skeleton {
    private com.musicstore.ws.OrderService impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "order"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.musicstore.com/", "po"), com.musicstore.ws.Po.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ccinfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.musicstore.com/", "creditCardDetails"), com.musicstore.ws.CreditCardDetails.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("orderConfirmation", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "po"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "orderConfirmation"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("orderConfirmation") == null) {
            _myOperations.put("orderConfirmation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("orderConfirmation")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAccountByUserName", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "account"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "getAccountByUserName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAccountByUserName") == null) {
            _myOperations.put("getAccountByUserName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAccountByUserName")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "account"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.musicstore.com/", "account"), com.musicstore.ws.Account.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("createAccount", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "account"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "createAccount"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createAccount") == null) {
            _myOperations.put("createAccount", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("createAccount")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cart"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.musicstore.com/", "po"), com.musicstore.ws.Po.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("saveOrder", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "po"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "saveOrder"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("saveOrder") == null) {
            _myOperations.put("saveOrder", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("saveOrder")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "items"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getCartItems", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "products"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "getCartItems"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCartItems") == null) {
            _myOperations.put("getCartItems", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getCartItems")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAccount", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "account"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "getAccount"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAccount") == null) {
            _myOperations.put("getAccount", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAccount")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "item"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getCartItem", _params, new javax.xml.namespace.QName("", "return"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://ws.musicstore.com/", "cd"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://ws.musicstore.com/", "getCartItem"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCartItem") == null) {
            _myOperations.put("getCartItem", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getCartItem")).add(_oper);
    }

    public OrderServiceImplPortBindingSkeleton() {
        this.impl = new com.musicstore.ws.OrderServiceImplPortBindingImpl();
    }

    public OrderServiceImplPortBindingSkeleton(com.musicstore.ws.OrderService impl) {
        this.impl = impl;
    }
    public com.musicstore.ws.Po orderConfirmation(com.musicstore.ws.Po order, com.musicstore.ws.CreditCardDetails ccinfo) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Po ret = impl.orderConfirmation(order, ccinfo);
        return ret;
    }

    public com.musicstore.ws.Account getAccountByUserName(java.lang.String username) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Account ret = impl.getAccountByUserName(username);
        return ret;
    }

    public com.musicstore.ws.Account createAccount(com.musicstore.ws.Account account) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Account ret = impl.createAccount(account);
        return ret;
    }

    public com.musicstore.ws.Po saveOrder(com.musicstore.ws.Po cart) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Po ret = impl.saveOrder(cart);
        return ret;
    }

    public com.musicstore.ws.Cd[] getCartItems(java.lang.String items) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Cd[] ret = impl.getCartItems(items);
        return ret;
    }

    public com.musicstore.ws.Account getAccount(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Account ret = impl.getAccount(username, password);
        return ret;
    }

    public com.musicstore.ws.Cd getCartItem(java.lang.String item) throws java.rmi.RemoteException
    {
        com.musicstore.ws.Cd ret = impl.getCartItem(item);
        return ret;
    }

}
