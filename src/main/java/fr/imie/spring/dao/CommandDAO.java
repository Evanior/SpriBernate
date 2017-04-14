package fr.imie.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.imie.spring.model.CommandModel;
import fr.imie.spring.model.PanierModel;
import fr.imie.spring.model.PlatModel;

@Repository
public class CommandDAO {
	
	@PersistenceContext
	private EntityManager em;

	public List<CommandModel> getListeCmd(){
		String query = "from CommandModel";
		Query q = em.createQuery(query);
		return q.getResultList();
	}

	public CommandModel getCommandByTable(int table) {
		String query = "from CommandModel where num_table = :table";
		Query q = em.createQuery(query);
		q.setParameter("table", table);
		return (CommandModel) q.getResultList().stream().findFirst().orElse(null);
	}
	
	public List<PlatModel> getPlatCommand(){
		String vue =  "SELECT nom, quantite FROM command "
				+ "INNER JOIN command_plat ON command.id_panier = command_plat.id_panier "
				+ "INNER JOIN plat ON plat.id_plat = command_plat.id_plat";
		Query q = em.createNativeQuery(vue);
		return q.getResultList();
	}
	
	@Transactional
	public void addCommandByTable(int table){
		CommandModel cmd = getCommandByTable(table);
		if(cmd == null){
			cmd = new CommandModel();
			cmd.setTable(table);
		}
		em.persist(cmd);
	}
	
}
