<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="i" begin="0" end="8" step="3">
	<div class="row">
		<c:forEach items="${itemList}" var="item" begin=i end=i+3>
			<div class="col-md-4">
				<a><img
					src="${item.img}"
					class="img-responsive"></a>
				<h2 contenteditable="true">${item.designation}</h2>
				<p>${item.description}</p>
				<a class="btn btn-warning btn-block">Ajouter au panier</a>
			</div>
		</c:forEach>
	</div>
</c:forEach>
