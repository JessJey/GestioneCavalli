<!doctype html>
<%@page import="it.prova.gestionecavalli.model.Cavallo"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Inserisci Nuovo Elemento</title>
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
				        <h5>Inserisci nuovo elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteInsertCavalloServlet" class="row g-3" novalidate="novalidate">
							
								<% Cavallo cavalloInPagina = (Cavallo)request.getAttribute("insert_cavallo_attr"); %>
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  
										value="<%=cavalloInPagina.getNome()!=null?cavalloInPagina.getNome():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="razza" class="form-label">Razza <span class="text-danger">*</span></label>
									<input type="text" name="razza" id="razza" class="form-control" placeholder="Inserire la razza"  
										value="<%=cavalloInPagina.getRazza()!=null?cavalloInPagina.getRazza():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="prezzo" class="form-label">Prezzo <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" 
									value="<%=cavalloInPagina.getPrezzo()!=null?cavalloInPagina.getPrezzo():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="datadinascita" class="form-label">Data di Nascita<span class="text-danger">*</span></label>
									<input class="form-control"  name="datadinascita" id="datadinascita" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=cavalloInPagina.getDataDiNascita()!=null? new SimpleDateFormat("yyyy-MM-dd").format(cavalloInPagina.getDataDiNascita()):""  %>" required/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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