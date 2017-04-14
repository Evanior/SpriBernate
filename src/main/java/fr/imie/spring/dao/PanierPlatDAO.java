package fr.imie.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.imie.spring.model.PanierModel;
import fr.imie.spring.model.PanierPlatJoined;
import fr.imie.spring.model.PlatModel;

@Repository
public class PanierPlatDAO {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	public PanierPlatJoined getJoinPanierPlat(PanierModel panier, PlatModel plat) {
		String query = "from PanierPlatJoined where id_panier = :id_panier and id_plat = :id_plat";
		Query q = em.createQuery(query);
		q.setParameter("id_panier", panier.getId());
		q.setParameter("id_plat", plat.getId());
		return (PanierPlatJoined) q.getResultList().stream().findFirst().orElse(null);
	}
	
	@Transactional
	public void addPlatPanier(PanierModel panier, PlatModel plat){
		
		PanierPlatJoined myJointure = getJoinPanierPlat(panier, plat);
		if(myJointure == null){
			myJointure = new PanierPlatJoined();
			myJointure.setPanier(panier);
			myJointure.setPlat(plat);
			myJointure.setQuantite(1);
		}else{
			myJointure.setQuantite(myJointure.getQuantite()+1);
		}
		
		em.persist(myJointure);
	}

	@Transactional
	public void removePanierPlat(PanierModel panier, PlatModel plat) {
		PanierPlatJoined myJointure = getJoinPanierPlat(panier, plat);
		int qte = myJointure.getQuantite();
		if(qte > 1){
			myJointure.setQuantite(myJointure.getQuantite()-1);
			em.persist(myJointure);
		}else{
			em.remove(myJointure);			
		}
	}
}
