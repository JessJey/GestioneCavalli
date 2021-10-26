package it.prova.gestionecavalli.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecavalli.model.Cavallo;
import it.prova.gestionecavalli.service.CavalloService;
import it.prova.gestionecavalli.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteCavalloServlet")
public class ExecuteDeleteCavalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteCavalloServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCavalloParam = request.getParameter("idCavallo");

		if (!NumberUtils.isCreatable(idCavalloParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		CavalloService cavalloServiceInstance = MyServiceFactory.getCavalloServiceInstance();
		try {
			Cavallo cavalloDaRimuovere = cavalloServiceInstance
					.caricaSingoloElemento(Long.parseLong(idCavalloParam));
			cavalloServiceInstance.rimuovi(cavalloDaRimuovere);
			request.setAttribute("listaCavalliAttribute", MyServiceFactory.getCavalloServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("cavallo/results.jsp").forward(request, response);

	}

}
