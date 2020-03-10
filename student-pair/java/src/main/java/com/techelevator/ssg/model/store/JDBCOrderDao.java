package com.techelevator.ssg.model.store;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCOrderDao implements OrderDao{

	private JdbcTemplate jdbcTemplate;
	
    @Autowired
    public JDBCOrderDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }
	
	// Saves the order id and Customer information
	// (Order_id, customer_name, address_1, address_2, city, state, zipcode)
	@Override
	public void saveOrder(Order order) {

		String sqlInsertOrder = "INSERT INTO orders (order_id, customer_name, street_address1 "
				+ ", street_address2, city, state, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?) ";
				
		//String customerName, String addressPart1, String addressPart2, String city
		//, String state, String zipcode
		jdbcTemplate.update(sqlInsertOrder, order.getOrderId(), order.getCustomerName(), 
				order.getAddressPart1(), order.getAddressPart2(), order.getCity(), 
				order.getState(), order.getZipcode());
		
		
	}

	// Saves order items, (order_id, product_id, quantity)
	@Override
	public void saveOrderItems(ShoppingCart shoppingCart, int orderId) {
		for (CartItem item : shoppingCart.getShoppingCartItems()) {
			
			String sqlInsertOrderItems = "INSERT INTO order_items (order_id, product_id, quantity) "
					+ "VALUES (?, ?, ?)";
			jdbcTemplate.update(sqlInsertOrderItems, orderId, item.getProductId(), item.getQuantity());
			
		}

	}
	
	public int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_order_id')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if (result.next()) {
			return result.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next product id");
		}
	}

}
