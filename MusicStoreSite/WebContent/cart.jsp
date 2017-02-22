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
			<div class="col-md-12">
				<div class="products">
					<h3>
						<c:if test="${servletMessage != ''}">
							<h4>${servletMessage}</h4>
						</c:if>

					</h3>
					<div class="row">
						<div class="col-md-3">
							<a class="btn btn-default" href="categories">Back to
								Categories</a>
						</div>
						<div class="col-md-6"></div>
						<div class="col-md-3">
							<c:choose>
								<c:when test="${authenticated}">
									<a class="btn btn-default" href="checkout">Continue to
										Checkout</a>
								</c:when>

								<c:otherwise>
									<a class="btn btn-default" href="login">Login to place
										order</a>
								</c:otherwise>
							</c:choose>

						</div>
					</div>

					<div class="row">
						<hr />
					</div>
					<div class="row">
						<div class="col-md-8">
							<h4>Title</h4>
						</div>
						<div class="col-md-2">
							<h4>Price</h4>
						</div>
						<div class="col-md-2">
							<h4>Remove</h4>
						</div>
					</div>
					<c:forEach items="${cart.getOrder().getPoitems()}" var="element">
						<div class="row">
							<div class="col-md-8">
								<h4>${element.getCd().getTitle()}</h4>
							</div>
							<div class="col-md-2">
								<h4>${element.getCd().getPrice()}</h4>
							</div>
							<div class="col-md-2">
								<a
									href="/MusicStoreSite/addtocart?remove=${element.getCd().getCdid()}">Remove</a>
							</div>
						</div>
					</c:forEach>
					<div class="row">
						<div class="col-md-6"></div>
						<div class="col-md-2">
							<h4 style="text-align: right;">Total</h4>
						</div>
						<div class="col-md-2">
							<h4>$${cart.getTotal()}</h4>
						</div>
						<div class="col-md-2"></div>

					</div>

					<!-- End Products -->

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
</html>