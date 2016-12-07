<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-pills nav-stacked">
	<%--  <%=categorieList%>
              <%=categorieActive%><!-- null si aucune--> --%>
	<c:forEach items="${categorieList}" var="categorie">
		<li <c:if test="${categorie = categorieActive}">class="active"</c:if>>
			<a href="#">${categorie}</a>
		</li>
	</c:forEach>
</ul>
<center>
	<h2>Filtres</h2>
</center>
<div class="jumbotron">
	<div class="container">
		<form role="form">
			<h3>Prix :</h3>
			<div class="col-xs-5">
				<label class="control-label">Min</label> <input class="form-control"
					type="number" placeholder="0">
			</div>
			<div class="col-xs-5">
				<label class="control-label">Max</label> <input class="form-control"
					type="number" placeholder="1000">
			</div>
			<div class="col-xs-2">
				<div class="text-center">
					<br>
					<button type="submit" class="btn btn-info btn-sm">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container">
		<br>
		<h3>Marque :</h3>
		<%-- <%=marqueList%> --%>
		<c:forEach items="${marqueList}" var="marque">
			<div class="checkbox">
				<label> <input type="checkbox" value="">${marque}
				</label>
			</div>
		</c:forEach>
	</div>
</div>
