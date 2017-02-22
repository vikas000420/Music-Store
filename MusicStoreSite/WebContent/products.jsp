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
<title>Music - ${category}</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<jsp:include page="jumbotran.jsp" />
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<jsp:include page="categorieslist.jsp" />
			</div>
			<div class="col-md-8">
				<div class="products">
					<h3>
						<a href="${pageContext.request.contextPath}/categories">CATEGORY</a>
						: ${category}

						<c:if test="${servletMessage != ''}">
							<h4>${servletMessage}</h4>
						</c:if>

					</h3>
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-4">
							<h4>Title</h4>
						</div>
						<div class="col-md-2">
							<h4>Availability</h4>
						</div>
						<div class="col-md-3">
							<h4>Add item to cart</h4>
						</div>

					</div>
					<div class="row">
						<hr />
					</div>
					<c:forEach items="${productList}" var="product">
						<div class="row">
							<div class="col-md-3">
								<img src="img/cd.jpg" width="40%" alt="Product Image" />
							</div>
							<div class="col-md-4">
								<a
									href="${pageContext.request.contextPath}/product?cdid=${product.cdid}">
									${product.title}</a>
							</div>
							<div class="col-md-2">${product.availability }</div>
							<div class="col-md-3">
								<c:if test="${product.availability gt 0}">
									<a href="/MusicStoreSite/addtocart?cdId=${product.cdid }"
										class="btn btn-default" id="AddToCart">Add to Cart</a>
								</c:if>
								<c:if test="${product.availability eq 0}">
									 Not available
								</c:if>
							</div>

						</div>

					</c:forEach>

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