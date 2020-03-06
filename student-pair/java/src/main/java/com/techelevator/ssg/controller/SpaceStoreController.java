package com.techelevator.ssg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.store.JdbcProductDao;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ShoppingCart;

@Controller
public class SpaceStoreController {

	@Autowired
	private JdbcProductDao productDao;
	
	@RequestMapping(path="/store", method = RequestMethod.GET)
	public String displayStore(HttpSession session) {
		
		List<Product> products = productDao.getAllProducts();
		if ((session.getAttribute("shoppingCart") == null)) {
			session.setAttribute("shoppingCart", new ShoppingCart());
		}
		
		session.setAttribute("products", products);
		
		return "spaceStore";
	}
	
	@RequestMapping(path="/product/detail", method = RequestMethod.GET)
	public String displayProductDetails(@RequestParam long id, ModelMap map, HttpSession session) {
		
		session.getAttribute("products");
		Product product = productDao.getProductById(id);
		map.addAttribute("product", product);
		session.setAttribute("product", product);
		
		return "productDetail";
	}
	
	@RequestMapping(path="/product/detail", method = RequestMethod.POST)
	public String buyProduct(@RequestParam int quantity, HttpSession session) {
		if ((session.getAttribute("shoppingCart") == null)) {
			session.setAttribute("shoppingCart", new ShoppingCart());
		}
//		@SuppressWarnings("unchecked")
//		List<Product> products = (List<Product>) session.getAttribute("products");
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
//		session.setAttribute("products", products);
		Product product = (Product) session.getAttribute("product");
		Map<Product, Integer> cart = shoppingCart.getProductsInCart();
		if (cart.containsKey(product)) {
			quantity += cart.get(product);
		}
		cart.put(product, quantity);
		shoppingCart.setProductsInCart(cart);

		session.setAttribute("shoppingCart", shoppingCart);
		return "redirect:/viewCart";
	}
	
	@RequestMapping(path="/viewCart", method = RequestMethod.GET)
	public String viewCart(ModelMap map, HttpSession session) {
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		map.addAttribute("shoppingCart", shoppingCart);
		return "viewCart";
	}
	
}
