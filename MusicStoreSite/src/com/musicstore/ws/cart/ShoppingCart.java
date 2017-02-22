package com.musicstore.ws.cart;

import com.musicstore.ws.Po;

public class ShoppingCart {

	private Po order;
	private int count;
	private int total;

	public Po getOrder() {
		return order;
	}

	public void setOrder(Po order) {
		this.order = order;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
