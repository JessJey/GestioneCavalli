package it.prova.gestionecavalli.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecavalli.model.Cavallo;
import it.prova.gestionecavalli.service.MyServiceFactory;
import it.prova.gestionecavalli.utility.UtilityCavalloForm;

@WebServlet("/ExecuteModificaCavalloServlet")
public class ExecuteModificaCavalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteModificaCavalloServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String idCavalloParam = request.getParameter("idCavallo");
		String nomeInputParam = request.getParameter("nome");
		String razzaInputParam = request.getParameter("razza");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataDiNascitaStringParam = request.getParameter("datadinascita");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Cavallo cavalloInstance = UtilityCavalloForm.createCavalloFromParams(nomeInputParam, razzaInputParam,
				prezzoInputStringParam, dataDiNascitaStringParam);
		
		
		if (!NumberUtils.isCreatable(idCavalloParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		cavalloInstance.setId(Long.parseLong(idCavalloParam));
		// se la validazione non risulta ok
		if (!UtilityCavalloForm.validateCavalloBean(cavalloInstance)) {
			request.setAttribute("modifica_cavallo_attr", cavalloInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("cavallo/modifica.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getCavalloServiceInstance().aggiorna(cavalloInstance);
			request.setAttribute("listaCavalliAttribute", MyServiceFactory.getCavalloServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("cavallo/results.jsp").forward(request, response);

	}

}
