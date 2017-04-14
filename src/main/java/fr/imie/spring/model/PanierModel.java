package fr.imie.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "panier")
public class PanierModel {
	
	@Id
	@GeneratedValue(generator="keygen")
	@GenericGenerator(strategy="increment", name = "keygen")
	@Column(name="id_panier")
	private int id;
	@Column(name="num_table",unique=true)
	private int table;

	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="list_plat_id_plat")
	private Set<PlatModel> list_plat;*/
	
	@OneToMany(mappedBy="panier", targetEntity=PanierPlatJoined.class, cascade=CascadeType.ALL)
	private Set<PanierPlatJoined> joined;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public Set<PlatModel> getListPlat() {
		return list_plat;
	}

	public void setListPlat(Set<PlatModel> listPlat) {
		this.list_plat = listPlat;
	}*/

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public Set<PanierPlatJoined> getJoined() {
		return joined;
	}

	public void setJoined(Set<PanierPlatJoined> joined) {
		this.joined = joined;
	}
	
}
