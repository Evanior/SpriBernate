package fr.imie.spring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "commande")
public class CommandModel {
	
	@Id
	@GeneratedValue(generator="keygen")
	@GenericGenerator(strategy="increment", name = "keygen")
	@Column(name="id_commande")
	private int id;
	@Column(name="num_table",unique=true)
	private int table;

	@ManyToMany
	private Set<PlatModel> list_plat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<PlatModel> getListPlat() {
		return list_plat;
	}

	public void setListPlat(Set<PlatModel> listPlat) {
		this.list_plat = listPlat;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}
	
	
	
}
