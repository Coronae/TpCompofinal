<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="Index">Achat compulsif</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse">
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input id="valueSearch" name="valueSearch" type="text"
						class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Valider</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${userSession == null}">
					<form method="post" action="Connexion">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Connexion <span class="caret"></span></a>
							<ul class="dropdown-menu">
								
									<li>
										<div class="text-center">Connexion</div>
									</li>
									<li role="separator" class="divider"></li>
									<li><input id="emailClient" name="emailUser" type="text"
										placeholder="Uname or Email" onclick="return false;"
										class="form-control input-sm"></li>
									<li><input id="passwordClient" name="passwordUser"
										type="password" placeholder="Password"
										class="form-control input-sm" name="password"></li> <span
										class='inline-block highlight-error'>${formUser.erreurs['emailUser']}</span>
									<span class='inline-block highlight-error'>${formUser.erreurs['passwordUser']}</span>
									<br>
									<li>
										<div class="text-center">
											<button type="submit" class="btn btn-success btn-sm">Sign
												in</button>
										</div>
									</li>
								
								<li role="separator" class="divider"></li>
								<div class="text-center">
									<li><a href="Inscription">Pas encore inscrit ?</a></li>
								</div>
							</ul></li>
							</form>
					</c:when>
					<c:otherwise>
						<button class="btn btn-error" action="Deconnexion">Déconnexion</button>
					</c:otherwise>
				</c:choose>
			</ul>
			<c:if test="${sessionScope.userSession != null}">
			<ul class="nav navbar-nav navbar-right">
				<a href="<c:url value="/Panier"/>"><img
					src="panier.png" style="max-width: px"
					class="center-block img-responsive img-rounded"></a>
			</ul>
			</c:if>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
    queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file://
    -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual
    files as needed -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>