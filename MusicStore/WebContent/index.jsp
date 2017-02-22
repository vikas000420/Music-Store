<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Service Site</title>
</head>
<body>
	<div>
		<h1 align="center" >This is WebService Landing page
			</h1>
			<%
				Date date = new Date();
				out.print("<h2 align=\"center\">" + date.toString() + "</h2>");
			%>
			<a align="center" href="<%=request.getRequestURI()%>">
			<h3>Load page Again</h3></a>
	</div>
</body>
</html>