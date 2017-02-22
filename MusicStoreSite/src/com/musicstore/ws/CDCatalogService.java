/**
 * CDCatalogService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.musicstore.ws;

public interface CDCatalogService extends java.rmi.Remote {
    public com.musicstore.ws.Cd[] getProductList(java.lang.String category) throws java.rmi.RemoteException;
    public java.lang.String[] getCategoryList() throws java.rmi.RemoteException;
    public com.musicstore.ws.Cd getProductInfo(java.lang.String cdid) throws java.rmi.RemoteException;
}
