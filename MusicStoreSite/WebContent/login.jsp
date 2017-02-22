<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/jumbotron.css" type="text/css"
	media="all" />
<title>Music Store</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<jsp:include page="jumbotran.jsp" />
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-6">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<c:if test="${servletMessage != ''}">
						<h4>${servletMessage}</h4>
					</c:if>
					<form class="form-signin" action="login" method="post">
						<h2 class="form-signin-heading">Please sign in</h2>
						<label for="username" class="sr-only">Email address</label> <input
							type="text" id="username" autocomplete="off" name="username"
							class="form-control" placeholder="User Name" required autofocus>
						<label for="password" class="sr-only">Password</label> <input
							type="password" autocomplete="off" id="password" name="password"
							class="form-control" placeholder="Password" required>

						<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
							in</button>
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
			<div class="col-md-6">
				<div class="products">
					<H4>Don't have an account create one now</H4>
					<a class="btn btn-lg btn-primary btn-block" href="createaccount"
						type="btn">Create Account</a>
				</div>
			</div>

		</div>

		<hr>

		<jsp:include page="footer.jsp" />
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="javascript/jquery.min.js"></script>
	<script src="javascript/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="javascript/ie10-viewport-bug-workaround.js"></script>
</body>