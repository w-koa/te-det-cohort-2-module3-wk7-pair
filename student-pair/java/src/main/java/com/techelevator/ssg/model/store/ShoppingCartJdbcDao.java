package com.techelevator.ssg.model.store;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCartJdbcDao implements ShoppingCartDao{

	// Order_id, customer_name, address_1, address_2, city, state, zipcode
	
	@Override
	public void saveOrder() {

		String sqlInsertOrder = "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		
		
	}

}
