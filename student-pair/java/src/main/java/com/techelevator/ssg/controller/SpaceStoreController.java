package com.techelevator.ssg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.store.CartItem;
import com.techelevator.ssg.model.store.DollarAmount;
import com.techelevator.ssg.model.store.JDBCOrderDao;
import com.techelevator.ssg.model.store.JdbcProductDao;
import com.techelevator.ssg.model.store.Order;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ShoppingCart;

@Controller
public class SpaceStoreController {

	@Autowired
	private JdbcProductDao productDao;
	@Autowired
	private JDBCOrderDao orderDao;

	@RequestMapping(path = "/store", method = RequestMethod.GET)
	public String displayStore(HttpSession session) {

		List<Product> products = productDao.getAllProducts();
		// Creates a new ShoppingCart if none exists
		if ((session.getAttribute("shoppingCart") == null)) {
			session.setAttribute("shoppingCart", new ShoppingCart());
		}

		session.setAttribute("products", products);

		return "spaceStore";
	}

	@RequestMapping(path = "/product/detail", method = RequestMethod.GET)
	public String displayProductDetails(@RequestParam long id, ModelMap map, HttpSession session) {

		// Gets product that was clicked and loads information into detail variables
		Product product = productDao.getProductById(id);
		map.addAttribute("product", product);
		session.setAttribute("product", product);

		return "productDetail";
	}

	@RequestMapping(path = "/product/detail", method = RequestMethod.POST)
	public String buyProduct(@RequestParam int quantity, @RequestParam long id, HttpSession session) {

		// Pulls product from GET page, makes it into a new cartItem and sets attributes
		Product product = (Product) session.getAttribute("product");
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getId());
		cartItem.setProductName(product.getName());
		cartItem.setImageName(product.getImageName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setItemTotal(cartItem.getItemTotal(product.getPrice(), quantity));

		// Creates a new ShoppingCart if none exists, puts CartItem in and saves to
		// session
		if ((session.getAttribute("shoppingCart") == null)) {
			ShoppingCart shoppingCart = new ShoppingCart();
			List<CartItem> shoppingCartList = shoppingCart.getShoppingCartItems(); // empty list
			shoppingCartList.add(cartItem);
			DollarAmount newGrandTotal = shoppingCart.getGrandTotal(shoppingCartList);
			shoppingCart.setCartGrandTotal(newGrandTotal);
			session.setAttribute("shoppingCart", shoppingCart);
		} else {
			// Gets list of items in cart from session
			ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
			List<CartItem> shoppingCartList = shoppingCart.getShoppingCartItems();
			int cartIndex = itemFound(shoppingCartList, id);

			// If item is found, sets new quantity at index, sets new itemTotal, and sets
			// new GrandTotal
			if (cartIndex != -1) {

				cartItem = shoppingCartList.get(cartIndex);
				int newQuantity = cartItem.getQuantity() + quantity;
				DollarAmount newItemTotal = cartItem.getItemTotal(cartItem.getPrice(), newQuantity);
				cartItem.setQuantity(newQuantity);
				cartItem.setItemTotal(newItemTotal);

			} else {

				// If item is not found, adds to cart and sets new GrandTotal
				shoppingCartList.add(cartItem);
				shoppingCart.setShoppingCartItems(shoppingCartList);
			}
			// Sets new GrandTotal before saving session
			DollarAmount newGrandTotal = shoppingCart.getGrandTotal(shoppingCartList);
			shoppingCart.setCartGrandTotal(newGrandTotal);

			session.setAttribute("shoppingCart", shoppingCart);
		}
		return "redirect:/viewCart";
	}

	// This method finds item and returns the index position in list. Thanks Andy.
	public int itemFound(List<CartItem> orderItemList, long itemId) {
		for (int i = 0; i < orderItemList.size(); i++) {
			if (orderItemList.get(i).getProductId() == itemId) {
				return i;
			}
		}
		return -1;
	}

	@RequestMapping(path = "/viewCart", method = RequestMethod.GET)
	public String viewCart(ModelMap map, HttpSession session) {

		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		map.addAttribute("shoppingCart", shoppingCart);
		return "viewCart";
	}

	@RequestMapping(path = "/checkout", method = RequestMethod.GET)
	public String displayCheckout() {

		return "storeCheckout";
	}

	@RequestMapping(path = "/checkout", method = RequestMethod.POST)
	public String processCheckout(@RequestParam String customerName, @RequestParam String addressPart1,
			@RequestParam(required = false) String addressPart2, @RequestParam String city, @RequestParam String state,
			@RequestParam String zipcode, HttpSession session) {
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		Order order = new Order();
		int newId = orderDao.getNextId();
		order.setOrderId(newId);
		order.setCustomerName(customerName);
		order.setAddressPart1(addressPart1);
		order.setAddressPart2(addressPart2);
		order.setCity(city);
		order.setState(state);
		order.setZipcode(zipcode);
		
		orderDao.saveOrder(order);
		orderDao.saveOrderItems(shoppingCart, order.getOrderId());
		

		return "redirect:/thanks";
	}
	
	@RequestMapping(path = "/thanks", method = RequestMethod.GET)
	public String displayThanksPage(HttpSession session) {
		session.invalidate();
		
		return "storeThanks";
	}
}
