<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes\header.jsp">
	<jsp:param name="client" value="${userSession}" />
</jsp:include>
<body>
    <div class="section">
      <div class="container">
      <form role="form" action="Panier">
        <c:forEach items="${itemListPanier}" var="item">
        <div class="row">
          <div class="col-md-2"></div>
          <div class="col-md-8">
            <div class="row">
              <div class="col-md-2">
                <img src="${item.img}"class="img-responsive">
              </div>
              <div class="col-md-4">
                <h4>${item.designation}</h4>
              </div>
              <div class="col-md-2">
                <h4>QuantitÃ© :</h4>
              </div>
              <div class="col-md-2">
                <input type="number" class="form-control" id="<c:out value="${item.id}"/>"  max="${item.quantiteRestante}">
              </div>
              <div class="col-md-2">
                <a class="btn btn-danger">Supprimer</a>
              </div>
            </div>
          </div>
          <div class="col-md-2"><button type="submit" class="btn btn-error">Submit</button></div>
        </div>
      </c:forEach>
      </form>
      </div>
    </div>



</body></html>
