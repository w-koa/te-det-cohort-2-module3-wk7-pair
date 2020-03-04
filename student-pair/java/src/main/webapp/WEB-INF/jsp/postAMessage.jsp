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

		<header>
			<h2 class="centered">New Geek Post</h2>
		</header>

		<c:url var="formAction" value="/postAMessage" />

		<form method="POST" action="${formAction}">

			<div class="formInputGroup">
				<label for="userName">User Name:</label> <input type="text"
					name="username" />
			</div>
			<div class="formInputGroup">
				<label for="subject">Subject:</label> <input type="text"
					name="subject" />
			</div>
			<div class="formInputGroup">
				<label for="message">Message:</label> <textarea 
					name="message" cols="50" rows="10"></textarea>
			</div>
			<input class="formSubmitButton" type="submit"
					value="Submit!" />
		</form>
	</section>
</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />