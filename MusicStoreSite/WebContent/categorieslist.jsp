<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty categoryList}">
	<h4>Music Categories</h4>
	<ul class="list-group">
		<c:forEach items="${categoryList}" var="categoryName">
			<li class="list-group-item"><a
				href="${pageContext.request.contextPath}/products?category=${categoryName}"><span>${categoryName}</span></a></li>
		</c:forEach>
	</ul>
</c:if>




