package com.techelevator.ssg.model.store;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	private Map<Product, Integer> productsInCart = new HashMap<Product, Integer>();
	private DollarAmount itemTotal;
	private DollarAmount cartTotal;
	
	
	public DollarAmount getProductTotal() {
		int productTotal = 0;
		for (Product product : productsInCart.keySet()) {
			int quantity = productsInCart.get(product);
			DollarAmount price = product.getPrice();
			int cents = price.getCents();
			int dollars = price.getDollars();
			cents = cents + (dollars * 100);
			
			productTotal = quantity * cents;
		}
		return new DollarAmount(productTotal);
	}
	
	public DollarAmount getGrandTotal() {
		int grandTotal = 0;
		for (Product product : productsInCart.keySet()) {
			int quantity = productsInCart.get(product);
			DollarAmount price = product.getPrice();
			int cents = price.getCents();
			int dollars = price.getDollars();
			cents = cents + (dollars * 100);
			
			grandTotal = grandTotal + (quantity * cents);
			
		}
		return new DollarAmount(grandTotal);
	}
	
	// Gets and Sets
	public Map<Product, Integer> getProductsInCart() {
		return productsInCart;
	}
	public void setProductsInCart(Map<Product, Integer> productsInCart) {
		this.productsInCart = productsInCart;
	}
	public DollarAmount getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(DollarAmount cartTotal) {
		this.cartTotal = cartTotal;
	}

	public DollarAmount getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(DollarAmount itemTotal) {
		this.itemTotal = itemTotal;
	}
}
