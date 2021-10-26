<!doctype html>
<%@page import="it.prova.gestionecavalli.model.Cavallo"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title> Visualizza Cavallo</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>
					
					    <div class='card-body'>
					    	<dl class="row">
					    	
						   <dt class="col-sm-3 text-right">Nome: </dt>
							  <c:out value="${visualizza_cavallo_attr.nome}"/>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Razza:</dt>
							   <c:out value="${visualizza_cavallo_attr.razza}"/>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
 								<c:out value="${visualizza_cavallo_attr.prezzo}"/>	
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Nascita:</dt>
							 <fmt:formatDate value="${visualizza_cavallo_attr.dataDiNascita}"  pattern="dd/MM/yyyy" var="datanascita"/>
					    	<c:out value="${datanascita}"></c:out>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        <a href="ListCavalliServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>