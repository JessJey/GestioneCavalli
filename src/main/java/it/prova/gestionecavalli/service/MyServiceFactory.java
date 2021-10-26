package it.prova.gestionecavalli.service;

import it.prova.gestionecavalli.dao.CavalloDAO;
import it.prova.gestionecavalli.dao.CavalloDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static CavalloService CAVALLO_SERVICE_INSTANCE = null;
	private static CavalloDAO CAVALLODAO_INSTANCE = null;

	public static CavalloService getCavalloServiceInstance() {
		if (CAVALLO_SERVICE_INSTANCE == null)
			CAVALLO_SERVICE_INSTANCE = new CavalloServiceImpl();

		if (CAVALLODAO_INSTANCE == null)
			CAVALLODAO_INSTANCE = new CavalloDAOImpl();

		CAVALLO_SERVICE_INSTANCE.setCavalloDao(CAVALLODAO_INSTANCE);

		return CAVALLO_SERVICE_INSTANCE;
	}

}
