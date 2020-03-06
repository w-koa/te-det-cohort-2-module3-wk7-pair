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

		<div>
			<table id="table">
				<tr>
					<th></th>
					<th>Name</th>
					<th>Price</th>
					<th>Qty.</th>
					<th>Total</th>
				</tr>
				<c:forEach var="item" items="${shoppingCart.productsInCart}">
					<tr>
						<td><img src="img/${item.key.imageName}" alt="productImage" /></td>
						<td><c:out value="${item.key.name}" /></td>
						<td><c:out value="${item.key.price}" /></td>
						<td><c:out value="${item.value}" /></td>
						<td><c:out value="${shoppingCart.productTotal}" /></td>
					</tr>
					

				</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<th>Grand Total:</th>
						<td><c:out value="${shoppingCart.grandTotal}" /></td>
					</tr>
			</table>


		</div>

	</section>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />