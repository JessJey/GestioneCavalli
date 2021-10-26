package it.prova.gestionecavalli.service;

import java.util.List;

import it.prova.gestionecavalli.dao.CavalloDAO;
import it.prova.gestionecavalli.model.Cavallo;

public interface CavalloService {

	// questo mi serve per injection
	public void setCavalloDao(CavalloDAO articoloDao);

	public List<Cavallo> listAll() throws Exception;

	public Cavallo caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Cavallo input) throws Exception;

	public void inserisciNuovo(Cavallo input) throws Exception;

	public void rimuovi(Cavallo input) throws Exception;

	public List<Cavallo> findByExample(Cavallo input) throws Exception;

}
