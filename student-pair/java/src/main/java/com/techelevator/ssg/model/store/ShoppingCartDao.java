package com.techelevator.ssg.model.store;

import org.springframework.stereotype.Component;

@Component
public interface ShoppingCartDao {

	public void saveOrder(ShoppingCart shoppingCart);
	public void saveOrderItems();
}
