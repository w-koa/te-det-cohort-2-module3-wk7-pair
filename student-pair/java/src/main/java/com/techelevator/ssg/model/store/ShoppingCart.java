package com.techelevator.ssg.model.store;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	
	private List<CartItem> shoppingCartItems = new ArrayList<>();
	private DollarAmount cartGrandTotal;
	
	// Method(s)
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

	public List<CartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(List<CartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

}
