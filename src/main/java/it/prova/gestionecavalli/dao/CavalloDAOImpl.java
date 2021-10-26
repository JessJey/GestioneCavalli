package it.prova.gestionecavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionecavalli.model.Cavallo;


public class CavalloDAOImpl implements CavalloDAO {

	private EntityManager entityManager;

	@Override
	public List<Cavallo> list() throws Exception {
		return entityManager.createQuery("from Cavallo", Cavallo.class).getResultList();
	}

	@Override
	public Cavallo findOne(Long id) throws Exception {
		return entityManager.find(Cavallo.class, id);
	}

	@Override
	public void update(Cavallo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.merge(input);

	}

	@Override
	public void insert(Cavallo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Cavallo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
