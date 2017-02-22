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
			<div class="col-md-4">
				<jsp:include page="categorieslist.jsp" />
			</div>

			<div class="col-md-8">
				<div class="row">
					<h3 style="text-align: center; color: red">Most Best Sellers</h3>
				</div>
				<c:forEach items="${TopProducts }" var="cd">
					<div class="row">
						<div class="col-md-4">
							<img src="img/cd1.jpg" width="60%" alt="Product Image" />
						</div>
						<div class="col-md-8">
							<h4>
								<a href="${pageContext.request.contextPath}/product?cdid=${cd.getCdid()}">
									${cd.getTitle()}</a>
							</h4>
						</div>
					</div>

				</c:forEach>


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