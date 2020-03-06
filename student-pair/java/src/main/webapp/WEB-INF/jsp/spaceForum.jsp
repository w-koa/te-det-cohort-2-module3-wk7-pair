<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<head>
<meta charset="ISO-8859-1">
<title>Space Forum</title>
</head>
<body>
	<section id="main-content">

		<header>
					<h2 class="centered">Solar System Geek Forum</h2>
		</header>
		<c:url var="postAMessage" value="/postAMessage"/>
		<a class="centered" href="${postAMessage}"> Post A Message</a>

		<div class="posts">
			<c:forEach var="post" items="${forumPosts}">
				<div class="post">
					<h4>
						<c:out value="${post.subject}"/>
					</h4>
					<p>
					 	<c:out value="by ${post.username} on ${post.datePosted}"/>
					</p>
					<p class="message">
						<c:out value= "${post.message}"/>
					</p>
				</div>
			</c:forEach>
		</div>
		


		
	</section>
</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />