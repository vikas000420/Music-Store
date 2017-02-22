<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" style="font-weight: bold;color: white;" href="categories">Music Store</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="categories">Home</a></li>
				<li class="active"><a href="categories">Categories</a></li>
				<c:if test="${loggedName == ''}">
					<li class="active"><a href="login">Login</a></li>
					<li class="active"><a href="createaccount">CreateAccount</a></li>
				</c:if>
				<c:if test="${loggedName != ''}">
					<li style="color: #ffffff">Hello <strong>${loggedName}</strong></li>
					<li class="active"><a href="logout">Logout</a></li>
				</c:if>
				 	<li class="active"><a href="cart">${cart.getCount()} items</a></li>
				 
			</ul>
			<c:if test="${loggedName == ''}">
				<form class="navbar-form navbar-right" action="login" method="post">
					<div class="form-group">
						<input type="text" id="username" name="username"
							placeholder="User Name" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" id="password" name="password"
							placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</c:if>
		</div>
		<!--/.navbar-collapse -->
	</div>
</nav>
