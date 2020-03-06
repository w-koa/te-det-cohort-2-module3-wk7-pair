package com.techelevator.ssg.model.store;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCartJdbcDao implements ShoppingCartDao{

	@Override
	public void saveOrder() {

		String sqlInsertOrder = "INSERT INTO orders VALUES (?, ?, ?, ?)";
	}

}
