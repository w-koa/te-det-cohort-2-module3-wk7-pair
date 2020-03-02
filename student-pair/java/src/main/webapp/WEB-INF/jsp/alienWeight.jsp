<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section id="main-content">

		<header><h2 class="centered">Alien Weight Calculator</h2></header>
		<c:url var="formAction" value="/alienWeightCalculator" />

		<form method="GET" action="${formAction}">

			<div class="formInputGroup">
				<label for="planet">Choose a Planet:</label> <select
					name="planet">
					<option value="Mercury">Mercury</option>
					<option value="Venus">Venus</option>
					<option value="Mars">Mars</option>
					<option value="Jupiter">Jupiter</option>
					<option value="Saturn">Saturn</option>
					<option value="Uranus">Uranus</option>
					<option value="Neptune">Neptune</option>
				</select>
			</div>
			<div class="formInputGroup">
				<label for="weight">Enter Your Earth Weight:</label> <input type="text"
					name="weight"/>
			</div>
			<button><input class="formSubmitButton" type="submit" value="Calculate Weight" /></button>

		</form>

	</section>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />