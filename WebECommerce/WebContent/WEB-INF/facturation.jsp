<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes\header.jsp">
	<jsp:param name="client" value="${userSession}" />
</jsp:include>
<body>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="text-center">
						<h1>Facturation</h1>
					</div>
					<form role="form" action="Facturation">
						<div class="form-group">
							<label class="control-label" for="numero">Numéro de la carte</label> <input
								class="form-control" id="numero" 
								type="text">
						</div>
						<div class="form-group">
							<label class="control-label" for="cryptogramme">Cryptogramme
								visuel</label> <input class="form-control" id="cryptogramme"
								type="text">
						</div>
						<div class="text-center">
							<a class="btn btn-warning btn-block" type=submit>Payer</a></div>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>