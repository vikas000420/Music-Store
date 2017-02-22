package com.musicstore.ws;

public class CDCatalogServiceProxy implements com.musicstore.ws.CDCatalogService {
	private String _endpoint = null;
	private com.musicstore.ws.CDCatalogService cDCatalogService = null;

	public CDCatalogServiceProxy() {
		_initCDCatalogServiceProxy();
	}

	public CDCatalogServiceProxy(String endpoint) {
		_endpoint = endpoint;
		_initCDCatalogServiceProxy();
	}

	private void _initCDCatalogServiceProxy() {
		try {
			cDCatalogService = (new com.musicstore.ws.CDCatalogServiceImplServiceLocator())
					.getCDCatalogServiceImplPort();
			if (cDCatalogService != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) cDCatalogService)._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) cDCatalogService)
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
		if (cDCatalogService != null)
			((javax.xml.rpc.Stub) cDCatalogService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.musicstore.ws.CDCatalogService getCDCatalogService() {
		if (cDCatalogService == null)
			_initCDCatalogServiceProxy();
		return cDCatalogService;
	}

	public com.musicstore.ws.Cd getProductInfo(java.lang.String cdid) throws java.rmi.RemoteException {
		if (cDCatalogService == null)
			_initCDCatalogServiceProxy();
		return cDCatalogService.getProductInfo(cdid);
	}

	public com.musicstore.ws.Cd[] getProductList(java.lang.String category) throws java.rmi.RemoteException {
		if (cDCatalogService == null)
			_initCDCatalogServiceProxy();
		return cDCatalogService.getProductList(category);
	}

	public java.lang.String[] getCategoryList() throws java.rmi.RemoteException {
		if (cDCatalogService == null)
			_initCDCatalogServiceProxy();
		return cDCatalogService.getCategoryList();
	}

}