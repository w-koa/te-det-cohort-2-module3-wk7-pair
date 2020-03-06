<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<head>
<meta charset="ISO-8859-1">
<title>Solar System Geek Gift Shop</title>
</head>
<body>
	<section id="main-content">
		<header>
			<h2 class="centered">Solar System Geek Gift Shop</h2>
		</header>

		<div>
			<c:forEach var="product" items="${products}">
				<div class="productInfo">
					<c:url var="productDetails" value = "/product/detail?id=${product.id}"/>
					<a href="${productDetails}"> <img
						src="img/${product.imageName}"></a>
					<div>
						<h2>${product.name}</h2>
						<h2 id="blue">${product.price}</h2>
					</div>

				</div>
			</c:forEach>

		</div>

	</section>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />