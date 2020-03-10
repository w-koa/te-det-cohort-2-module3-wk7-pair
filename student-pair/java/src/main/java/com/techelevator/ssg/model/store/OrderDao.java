package com.techelevator.ssg.model.store;

import org.springframework.stereotype.Component;

@Component
public interface OrderDao {

	public void saveOrder(Order order);
	public void saveOrderItems(ShoppingCart shoppingCart, int orderId);
}
