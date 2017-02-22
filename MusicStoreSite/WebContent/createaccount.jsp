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

		<c:if test="${servletMessage != ''}">
			<h4 class="alert alert-danger">${servletMessage}</h4>
		</c:if>
		<div class="row">
			<h3 style="text-align: center;">Register new account</h3>

		</div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<form class="form-signin" action="createaccount" method="post">
					<div class="row">
						<div class="col-md-4">
							<label for="firstName">First Name</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="firstName" name="firstName"
								class="form-control" placeholder="First Name"
								value="${account.getFirstname()}" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="lastName">Last Name</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="lastName" name="lastName"
								class="form-control" value="${account.getLastname()}"
								placeholder="Last Name" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="email">Email</label>
						</div>
						<div class="col-md-8">
							<input type="email" id="email" value="${account.getEmail()}"
								name="email" class="form-control" placeholder="Email" required
								autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="email">User Name</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="username" name="username"
								class="form-control" placeholder="User Name" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="password">Password</label>
						</div>
						<div class="col-md-8">
							<input type="password" id="password" name="password"
								class="form-control" placeholder="Password" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="confirmPassword">Confirm Password</label>
						</div>
						<div class="col-md-8">
							<input type="password" id="confirmPassword"
								name="confirmPassword" class="form-control"
								placeholder="Confirm Password" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-12" style="text-align: center;">
							<hr />
							<label>Enter Your Shipping Address here</label>
						</div>

					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="street">Street</label>
						</div>
						<div class="col-md-8">
							<input type="text" value="${account.getAddress().getStreet()}"
								id="street" name="street" class="form-control"
								placeholder="Street" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="city">City</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="city"
								value="${account.getAddress().getCity()}" name="city"
								class="form-control" placeholder="City" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="province">Province</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="province"
								value="${account.getAddress().getProvince()}" name="province"
								class="form-control" placeholder="Province" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="country">Country</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="country"
								value="${account.getAddress().getCountry()}" name="country"
								class="form-control" placeholder="Country" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="zip">Zip / Postal Code</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="zip" name="zip"
								value="${account.getAddress().getZip()}" class="form-control"
								placeholder="Zip / Postal code" required autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="phone">Phone</label>
						</div>
						<div class="col-md-8">
							<input type="text" id="phone"
								value="${account.getAddress().getPhone()}" name="phone"
								class="form-control" placeholder="Phone Number" required
								autofocus />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-8" style="margin-top: 10px">
							<button class="btn btn-lg btn-primary btn-block" type="submit">Create
								Account</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-2"></div>
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
</html>