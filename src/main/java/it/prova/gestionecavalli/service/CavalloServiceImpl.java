package it.prova.gestionecavalli.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionecavalli.dao.CavalloDAO;
import it.prova.gestionecavalli.model.Cavallo;
import it.prova.gestionecavalli.web.listener.LocalEntityManagerFactoryListener;

public class CavalloServiceImpl implements CavalloService {

	private CavalloDAO cavalloDao;

	public void setCavalloDao(CavalloDAO cavalloDao) {
		this.cavalloDao = cavalloDao;
	}

	@Override
	public List<Cavallo> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			cavalloDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return cavalloDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Cavallo caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			cavalloDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return cavalloDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Cavallo input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			cavalloDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			cavalloDao.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Cavallo input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			cavalloDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			cavalloDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Cavallo input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			cavalloDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			cavalloDao.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Cavallo> findByExample(Cavallo input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
