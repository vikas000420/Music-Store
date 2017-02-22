package com.musicstore.ws;

import java.rmi.RemoteException;

public class OrderServiceProxy implements com.musicstore.ws.OrderService {
	private String _endpoint = null;
	private com.musicstore.ws.OrderService orderService = null;

	public OrderServiceProxy() {
		_initOrderServiceProxy();
	}

	public OrderServiceProxy(String endpoint) {
		_endpoint = endpoint;
		_initOrderServiceProxy();
	}

	private void _initOrderServiceProxy() {
		try {
			orderService = (new com.musicstore.ws.OrderServiceImplServiceLocator()).getOrderServiceImplPort();
			if (orderService != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) orderService)._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) orderService)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (orderService != null)
			((javax.xml.rpc.Stub) orderService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.musicstore.ws.OrderService getOrderService() {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService;
	}

	public com.musicstore.ws.Account getAccount(java.lang.String username, java.lang.String password)
			throws java.rmi.RemoteException {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService.getAccount(username, password);
	}

	public com.musicstore.ws.Po saveOrder(com.musicstore.ws.Po cart) throws java.rmi.RemoteException {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService.saveOrder(cart);
	}

	public com.musicstore.ws.Account createAccount(com.musicstore.ws.Account account) throws java.rmi.RemoteException {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService.createAccount(account);
	}

	public com.musicstore.ws.Cd[] getCartItems(java.lang.String items) throws java.rmi.RemoteException {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService.getCartItems(items);
	}

	public com.musicstore.ws.Po orderConfirmation(com.musicstore.ws.Po order,
			com.musicstore.ws.CreditCardDetails ccinfo) throws java.rmi.RemoteException {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService.orderConfirmation(order, ccinfo);
	}

	public com.musicstore.ws.Cd getCartItem(java.lang.String item) throws java.rmi.RemoteException {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService.getCartItem(item);
	}

	@Override
	public Account getAccountByUserName(String username) throws RemoteException {
		if (orderService == null)
			_initOrderServiceProxy();
		return orderService.getAccountByUserName(username);
	}

}