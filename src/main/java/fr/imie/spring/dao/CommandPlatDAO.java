package fr.imie.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.imie.spring.model.CommandModel;
import fr.imie.spring.model.CommandPlatJoined;
import fr.imie.spring.model.PanierPlatJoined;
import fr.imie.spring.model.PlatModel;

@Repository
public class CommandPlatDAO {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	public CommandPlatJoined getJoinCommandPlat(CommandModel cmd, PlatModel plat) {
		String query = "from CommandPlatJoined where id_command = :id_command and id_plat = :id_plat";
		Query q = em.createQuery(query);
		q.setParameter("id_command", cmd.getId());
		q.setParameter("id_plat", plat.getId());
		return (CommandPlatJoined) q.getResultList().stream().findFirst().orElse(null);
	}
	
	@Transactional
	public void savePlatCommand(CommandModel cmd, PanierPlatJoined panier){
		
		CommandPlatJoined myJointure = new CommandPlatJoined();
		myJointure.setCommand(cmd);
		myJointure.setPlat(panier.getPlat());
		myJointure.setQuantite(panier.getQuantite());
		em.persist(myJointure);	
	}

	@Transactional
	public void removeCommandPlat(CommandModel panier, PlatModel plat) {
		CommandPlatJoined myJointure = getJoinCommandPlat(panier, plat);
		int qte = myJointure.getQuantite();
		if(qte > 1){
			myJointure.setQuantite(myJointure.getQuantite()-1);
			em.persist(myJointure);
		}else{
			em.remove(myJointure);			
		}
	}
}
