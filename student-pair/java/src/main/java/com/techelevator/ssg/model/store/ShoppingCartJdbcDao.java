package com.techelevator.ssg.model.store;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartJdbcDao implements ShoppingCartDao{

	private JdbcTemplate jdbcTemplate;
	
	// Saves the order id and Customer information
	// (Order_id, customer_name, address_1, address_2, city, state, zipcode)
	@Override
	public void saveOrder(ShoppingCart shoppingCart) {

		String sqlInsertOrder = "INSERT INTO orders (customer_name, street_address1 "
				+ ", street_address2, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?) "
				+ "RETURNING order_id";
		//String customerName, String addressPart1, String addressPart2, String city
//		, String state, String zipcode
		jdbcTemplate.update(sqlInsertOrder, newId, shoppingCart.getCustomerName(), 
				shoppingCart.getAddressPart1(), shoppingCart.getAddressPart2(), shoppingCart.getCity(), 
				shoppingCart.getState(), shoppingCart.getZipcode());
		
		
	}

	// Saves order items, (order_id, product_id, quantity)
	@Override
	public void saveOrderItems() {


		String sqlInsertOrderItems = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
		
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_product_id')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if (result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next product id");
		}
	}

}
