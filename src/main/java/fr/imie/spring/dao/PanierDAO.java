package fr.imie.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.imie.spring.model.PanierModel;
import fr.imie.spring.model.PlatModel;

@Repository
public class PanierDAO {
	
	@PersistenceContext
	private EntityManager em;

	public List<PanierModel> getListeCmd(){
		String query = "from PanierModel";
		Query q = em.createQuery(query);
		return q.getResultList();
	}

	public PanierModel getPanierByTable(int table) {
		String query = "from PanierModel where num_table = :table";
		Query q = em.createQuery(query);
		q.setParameter("table", table);
		return (PanierModel) q.getResultList().stream().findFirst().orElse(null);
	}
	
	public List<PlatModel> getPlatByTable(int table){
		PanierModel pan = getPanierByTable(table);
		String vue =  "SELECT nom, prix, quantite FROM panier "
				+ "INNER JOIN panier_plat ON panier.id_panier = panier_plat.id_panier "
				+ "INNER JOIN plat ON plat.id_plat = panier_plat.id_plat where num_table = :table";
		Query q = em.createNativeQuery(vue);
		q.setParameter("table", table);
		return q.getResultList();
	}
	
	@Transactional
	public PanierModel addPanierByTable(int table){
		PanierModel panier = getPanierByTable(table);
		if(panier == null){
			panier = new PanierModel();
			panier.setTable(table);
		}
		em.persist(panier);
		return panier;
	}
	
	@Transactional
	public void removePanierByTable(int table){
		PanierModel panier = getPanierByTable(table);
		em.remove(panier);
	}
}
