<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<head>
<meta charset="ISO-8859-1">
<title>Solar System Geek Gift Shop - Checkout</title>
</head>
<body>
	<section id="main-content">
		<header>
			<h2 class="centered">Solar System Geek Gift Shop</h2>
		</header>

		<div>
			<c:url var="checkoutUrl" value="/checkout" />
			<form:form action="${checkoutUrl}" method="POST">
				<div>
					<label for="name">Name<input type="text" name="customerName"
						id="customerName" /></label>
				</div>
				<div>
					<label for="addressPart1">Address Line 1<input type="text"
						name="addressPart1" id="addressPart1" /></label>
				</div>
				<div>
					<label for="addressPart2">Address Line 2<input type="text"
						name="addressPart2" id="addressPart2" /></label>
				</div>
				<div>
					<label for="city">City<input type="text" name="city"
						id="city" /></label>
				</div>
				<div>
					<label for="state">State<input type="text" name="state"
						id="state" /></label>
				</div>
				<div>
					<label for="zipcode">Zip Code<input type="text"
						name="zipcode" id="zipcode" /></label>
				</div>
				<input type="submit" class="formSubmitButton" value="Check Out!"/>

			</form:form>



		</div>

	</section>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />