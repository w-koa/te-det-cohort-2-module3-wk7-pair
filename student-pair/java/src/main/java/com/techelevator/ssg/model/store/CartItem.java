package com.techelevator.ssg.model.store;

public class CartItem {
	
	private int orderId;
	private Long productId;
	private String productName;
	private String imageName;
	private DollarAmount price;
	private DollarAmount itemTotal;
	private int quantity;
	
	public DollarAmount getItemTotal(DollarAmount price, int quantity) {
		
		int cents = price.hashCode();
		cents = cents * quantity;
		return new DollarAmount(cents);
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public DollarAmount getPrice() {
		return price;
	}
	public void setPrice(DollarAmount price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DollarAmount getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(DollarAmount itemTotal) {
		this.itemTotal = itemTotal;
	}
	

}
