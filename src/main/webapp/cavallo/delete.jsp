<!doctype html>
<%@page import="it.prova.gestionecavalli.model.Cavallo"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Visualizza Elemento Da Rimuovere</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  <div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza cavallo da rimuovere</h5>
					    </div>
					     <% Cavallo cavalloInPagina = (Cavallo)request.getAttribute("delete_cavallo_attr"); %>
					    
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
							  <dd class="col-sm-9"><%=cavalloInPagina.getNome() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Razza:</dt>
							  <dd class="col-sm-9"><%=cavalloInPagina.getRazza() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9"><%=cavalloInPagina.getPrezzo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Nascita:</dt>
							  <dd class="col-sm-9"><%=cavalloInPagina.getDataDiNascita()!=null? new SimpleDateFormat("dd/MM/yyyy").format(cavalloInPagina.getDataDiNascita()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        
					        <form action="ExecuteDeleteCavalloServlet" method="post">
								<input type="hidden" name="idCavallo" value="<%=cavalloInPagina.getId() %>">
								<button type="submit" class='btn btn-outline-danger' style='width:90px' >Cancella</button>
								<a href="ListCavalliServlet" class='btn btn-outline-secondary' style='width:80px'>
					            	<i class='fa fa-chevron-left'></i> Back
					        	</a>
					        </form>
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