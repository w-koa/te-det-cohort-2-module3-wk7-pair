package com.techelevator.ssg.model.store;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	
	private int orderId;
	private List<CartItem> shoppingCartItems = new ArrayList<>();
	private DollarAmount cartGrandTotal;
	
	public DollarAmount getGrandTotal(List<CartItem> shoppingCartItems) {
		int grandTotal = 0;
		for (CartItem item : shoppingCartItems) {
			
			grandTotal = grandTotal + item.getItemTotal().hashCode();
			
		}
		return new DollarAmount(grandTotal);
	}
	
	// Gets and Sets

	public DollarAmount getCartGrandTotal() {
		return cartGrandTotal;
	}
	public void setCartGrandTotal(DollarAmount cartGrandTotal) {
		this.cartGrandTotal = cartGrandTotal;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<CartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(List<CartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}
}
