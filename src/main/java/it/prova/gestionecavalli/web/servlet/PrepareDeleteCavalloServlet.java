package it.prova.gestionecavalli.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecavalli.service.MyServiceFactory;


@WebServlet("/PrepareDeleteCavalloServlet")
public class PrepareDeleteCavalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteCavalloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCavalloParam = request.getParameter("idCavallo");

		if (!NumberUtils.isCreatable(idCavalloParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("delete_cavallo_attr", MyServiceFactory.getCavalloServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idCavalloParam)));
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("cavallo/delete.jsp").forward(request, response);
	}

}
