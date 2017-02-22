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
				<c:choose>
					<c:when test="${orderPlaced.status == 'ORDERED'}">
						<h3 style="text-align: center;">Order Successfully Completed.</h3>
					</c:when>
					<c:otherwise>
						<h3 style="text-align: center; color: red;">Credit Card
							Authorization Failed.</h3>
					</c:otherwise>
				</c:choose>
			</div>

			<hr>

			<jsp:include page="footer.jsp" />
		</div>
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