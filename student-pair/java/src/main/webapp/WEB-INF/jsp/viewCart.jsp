<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<head>
<meta charset="ISO-8859-1">
<title>Solar System Geek Gift Shop - Cart</title>
</head>
<body>
	<section id="main-content">
		<header>
			<h2 class="centered">Solar System Geek Gift Shop</h2>
		</header>
		<c:if test="${shoppingCart.shoppingCartItems.size() < 1}">
		<h2 class="centered"><c:out value = "Shopping cart is empty!"/></h2>
		test
		</c:if>
		<c:if test="${shoppingCart.shoppingCartItems.size() > 0}">
		test
			<div>
				<table id="table">
					<tr>
						<th></th>
						<th id="extraSpace">Name</th>
						<th>Price</th>
						<th>Qty.</th>
						<th>Total</th>
					</tr>
					<c:forEach var="item" items="${shoppingCart.shoppingCartItems}">
						<tr>
							<td><img src="img/${item.imageName}" alt="productImage" /></td>
							<td id="extraSpace"><c:out value="${item.productName}" /></td>
							<td><c:out value="${item.price}" /></td>
							<td><c:out value="${item.quantity}" /></td>
							<td><c:out value="${item.itemTotal}" /></td>
						</tr>


					</c:forEach>
					<tr>
						<td></td>
						<td id="extraSpace"></td>
						<td></td>
						<th>Grand Total:</th>
						<td><c:out value="${shoppingCart.cartGrandTotal }" /></td>
					</tr>
					<tr>
						<td></td>
						<td id="extraSpace"></td>
						<td></td>
						<c:url var="continueShopping" value="/store" />
						<td><a href="${continueShopping}">Continue Shopping</a></td>

						<c:url var="checkoutUrl" value="/checkout" />
						<td><a href="${checkoutUrl}">Check Out!</a></td>
					</tr>
				</table>
			</div>
		</c:if>
	</section>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />