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
	<jsp:include page="navigation.jsp" />
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-12">
				<h3>
					<c:if test="${servletMessage != ''}">
						<h4>${servletMessage}</h4>
					</c:if>
				</h3>

				<h3 style="text-align: center;">Order Details</h3>
				<h4 style="text-align: center;">Please check your items, and
					enter your Credit card details</h4>
			</div>

		</div>
		<div class="row">
			<hr />
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h4 style="color: red">Music title</h4>
			</div>
			<div class="col-md-2">
				<h4 style="color: red">Price</h4>
			</div>
		</div>
		<c:forEach items="${cart.getOrder().getPoitems()}" var="element">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h4>${element.getCd().getTitle()}</h4>
				</div>
				<div class="col-md-2">
					<h4>$${element.getCd().getPrice()}</h4>
				</div>
			</div>
		</c:forEach>
		<div class="row">
			<div class="col-md-8"></div>
			<div class="col-md-2" style="text-align: right">
				<strong>Total</strong>
			</div>
			<div class="col-md-2">
				<h4>$${cart.getTotal()}</h4>
			</div>
			<!-- End Products -->
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10">
				<h3 style="color: red;">Shipping Address</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10">

				<h3>
					<small>Street</small> ${cart.getOrder().getAddressBean().getStreet()}
				</h3>
				<h3>
					<small>City</small> ${cart.getOrder().getAddressBean().getCity()}
				</h3>
				<h3>
					<small>Province</small> ${cart.getOrder().getAddressBean().getProvince()}
				</h3>
				<h3>
					<small>Country</small> ${ cart.getOrder().getAddressBean().getCountry()}
				</h3>
				<h3>
					<small>Phone</small> ${ cart.getOrder().getAddressBean().getPhone()}
				</h3>
			</div>
			<div class="col-md-2"></div>
		</div>
		<form class="form-signin" action="placeorder" method="post">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<h3 style="color: red;">Payment details</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<label for="ccNumber">Credit Cart Number</label>
				</div>
				<div class="col-md-6">
					<input type="text" id="ccNumber" name="ccNumber"
						class="form-control" placeholder="Credit Cart Number" required
						autofocus />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<label for="nameOnCC">Name on Credit Card</label>
				</div>
				<div class="col-md-6">
					<input type="text" id="nameOnCC" name="nameOnCC"
						class="form-control" placeholder="Name on Credit Card" required
						autofocus />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<label for="cctype">CC Type</label>
				</div>
				<div class="col-md-6">
					<select class="form-control" name="cctype" id="cctype" size="1">
						<option value="">Select</option>
						<option value="MC">MasterCard</option>
						<option value="VI">VISA</option>
						<option value="AM">AMEX</option>
						<option value="OT">Other</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<label for="cccode">CCV code</label>
				</div>
				<div class="col-md-6">
					<input type="text" id="cccode" name="cccode" class="form-control"
						placeholder="CC code" required autofocus />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<label for="expmonth">Expiry Month</label>
				</div>
				<div class="col-md-6">
					<select name="expmonth" class="form-control" id="expmonth" size="1">
						<option value="01">January</option>
						<option value="02">February</option>
						<option value="03">March</option>
						<option value="04">April</option>
						<option value="05">May</option>
						<option value="06">June</option>
						<option value="07">July</option>
						<option value="08">August</option>
						<option value="09">September</option>
						<option value="10">October</option>
						<option value="11">November</option>
						<option value="12">December</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<label for="expYear">Expiry Year</label>
				</div>
				<div class="col-md-6">
					<select class="form-control" name="expYear" id="expYear" size="1">
						<option value="2015">2015</option>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
						<option value="2023">2023</option>
						<option value="2024">2024</option>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4"></div>
				<div class="col-md-4" style="margin-top: 10px">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Place
						Order</button>
				</div>
				<div class="col-md-2"></div>
			</div>
		</form>
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