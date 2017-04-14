package fr.imie.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.imie.spring.model.CommandModel;
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
		return (CommandModel) q.getSingleResult();
	}
	
}
