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
	
		<header><h2 class="centered">Alien Travel Calculator</h2></header>
	

		<c:url var="formAction" value="/travelTimeCalculator" />

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
				<label for="transportMethod">Choose a method of Transportation:</label> <select
					name="transportMethod">
					<option value="Walking">Walking</option>
					<option value="Car">Car</option>
					<option value="Bullet Train">Bullet Train</option>
					<option value="Boeing 747">Boeing 747</option>
					<option value="Condord">Condord</option>
				</select>
			
			
			
			</div>
			<div class="formInputGroup">
				<label for="weight">Enter Your Age:</label> <input
					type="text" name="age" />
			</div>
			<button>
				<input class="formSubmitButton" type="submit"
					value="Calculate Travel Time" />
			</button>

		</form>

	</section>

</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />