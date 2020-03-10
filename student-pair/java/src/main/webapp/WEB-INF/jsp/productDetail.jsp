<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<section id="main-content">

		<header>
			<h2 class="centered">Solar System Geek Gift Shop</h2>
		</header>
		<div class="productInfo">
			<div>
				<c:url var="productImage" value="/img/${product.imageName}" />
				<img src="${productImage}" alt="${product.name}" />
			</div>
			<div>
				<h2>${product.name}</h2>
				<h2 id="blue">${product.price}</h2>
				<p class="productDescription">${product.description}</p>
			
				<c:url value='/product/detail' var = 'processAddItemUrl' />
				<form action="${processAddItemUrl}" method="POST">
					<input type="hidden" name="name" value="${product.name}" /> 
					<input type="hidden" name="price" value ="${product.price}" /> 
					<input type="hidden" name="id" value="${product.id}" />
						<input type="number" name="quantity" id="quantity" min = "1" max="255"/> <label>Quantity
						to buy: <input type="submit" value="Add to Cart"
						class="formSubmitButton" />
					</label>
				</form>
			</div>
		</div>



	</section>
</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />