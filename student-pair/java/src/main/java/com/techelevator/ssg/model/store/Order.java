package com.techelevator.ssg.model.store;

public class Order {
	private String customerName;
	private String addressPart1;
	private String addressPart2;
	private String city;
	private String state;
	private String zipcode;
	private int orderId;

	public Order() {
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddressPart1() {
		return addressPart1;
	}

	public void setAddressPart1(String addressPart1) {
		this.addressPart1 = addressPart1;
	}

	public String getAddressPart2() {
		return addressPart2;
	}

	public void setAddressPart2(String addressPart2) {
		this.addressPart2 = addressPart2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}