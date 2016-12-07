<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes\header.jsp">
	<jsp:param name="client" value="${userSession}" />
</jsp:include>
<div class="section">
	<div class="container">
		<div class="row">

			<div class="col-md-4">
				<jsp:include page="includes/menuLateral.jsp">
					<jsp:param name="categorieList" value="${categorieList}" />
					<jsp:param name="marqueList" value="${marqueList}" />
					<jsp:param name="categorieActive" value="${categorieActive}" />
				</jsp:include>
			</div>
			<div class="col-md-8">
				<c:choose>
					<c:when test="${modeGrille == true}">
						<button id="buttonMode" name="buttonMode" type="button"
							class="btn btn-info">Mode Liste</button>
						<jsp:include page="includes/produitsgrid.jsp">
							<jsp:param name="itemList" value="${itemList}" />
						</jsp:include>
					</c:when>
					<c:otherwise>
						<button id="buttonMode" name="buttonMode" type="button"
							class="btn btn-info">Mode Grille</button>
						<jsp:include page="includes/produitsList.jsp">
							<jsp:param name="itemList" value="${itemList}" />
						</jsp:include>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</div>
</html>