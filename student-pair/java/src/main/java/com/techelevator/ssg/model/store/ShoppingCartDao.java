package com.techelevator.ssg.model.store;

import org.springframework.stereotype.Component;

@Component
public interface ShoppingCartDao {

	public void saveOrder();
	public void saveOrderItems();
}
