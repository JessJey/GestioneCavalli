package it.prova.gestionecavalli.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecavalli.model.Cavallo;

@WebServlet("/PrepareInsertCavalloServlet")
public class PrepareInsertCavalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("insert_cavallo_attr", new Cavallo());
		request.getRequestDispatcher("cavallo/insert.jsp").forward(request, response);

	}

}
