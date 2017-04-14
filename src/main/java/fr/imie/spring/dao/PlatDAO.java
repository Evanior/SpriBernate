package fr.imie.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.imie.spring.model.PlatModel;

@Repository
public class PlatDAO {
	
	@PersistenceContext
	private EntityManager em;

	public List<PlatModel> getListePlat(){
		String query = "from PlatModel";
		Query q = em.createQuery(query);
		return q.getResultList();
	}

	public PlatModel getPlatByName(String nom) {
		String query = "from PlatModel where nom = :nom";
		Query q = em.createQuery(query);
		q.setParameter("nom", nom);
		return (PlatModel) q.getResultList().stream().findFirst().orElse(null);
	}
	
}
