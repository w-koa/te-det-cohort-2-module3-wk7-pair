<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<section id="main-content">
		<div style="display: flex">
			<img src="img/${param.planet}.jpg" alt="${param.planet}" />
			<h2>If you are <c:out value="${param.earthAge}" /> years old on planet Earth,
			then you are <c:out value="${ageCalculator.alienAge}" /> ${param.planet} years old.</h2>
		</div>

	</section>



</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />