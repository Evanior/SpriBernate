package fr.imie.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "command")
public class CommandModel {
	
	@Id
	@GeneratedValue(generator="keygen")
	@GenericGenerator(strategy="increment", name = "keygen")
	@Column(name="id_commande")
	private int id;
	@Column(name="num_table",unique=true)
	private int table;

	@OneToMany(mappedBy="command", targetEntity=CommandPlatJoined.class, cascade=CascadeType.ALL)
	private Set<CommandPlatJoined> joined;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public Set<CommandPlatJoined> getJoined() {
		return joined;
	}

	public void setJoined(Set<CommandPlatJoined> joined) {
		this.joined = joined;
	}
	
}
