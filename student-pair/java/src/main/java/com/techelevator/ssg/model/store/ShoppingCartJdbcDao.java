package com.techelevator.ssg.model.store;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCartJdbcDao implements ShoppingCartDao{

	// Saves the order id and Customer information
	// (Order_id, customer_name, address_1, address_2, city, state, zipcode)
	@Override
	public void saveOrder() {

		String sqlInsertOrder = "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		
		
	}

	// Saves order items, (order_id, product_id, quantity)
	@Override
	public void saveOrderItems() {
		// TODO Auto-generated method stub
		
	}

}
