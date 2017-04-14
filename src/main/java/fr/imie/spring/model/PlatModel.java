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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "plat")
public class PlatModel {
	
	@Id
	@GeneratedValue(generator="keygen")
	@GenericGenerator(strategy="increment", name = "keygen")
	@Column(name="id_plat")
	private int id;
	@Column(unique=true)
	private String nom;
	@Column
	private String description;
	@Column
	private double prix;
	
	/*@ManyToMany(mappedBy="list_plat", fetch = FetchType.LAZY)
	private Set<PanierModel> paniers;
	@ManyToMany(mappedBy="list_plat", fetch = FetchType.LAZY)
	private Set<CommandModel> commands;*/
	
	@OneToMany(mappedBy="plat", targetEntity=PanierPlatJoined.class)
	private Set<PanierPlatJoined> joined;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	/*public Set<PanierModel> getPaniers() {
		return paniers;
	}
	public void setPanniers(Set<PanierModel> paniers) {
		this.paniers = paniers;
	}
	public Set<CommandModel> getCommands() {
		return commands;
	}
	public void setCommands(Set<CommandModel> commands) {
		this.commands = commands;
	}*/
	
	public Set<PanierPlatJoined> getJoined() {
		return joined;
	}

	public void setJoined(Set<PanierPlatJoined> joined) {
		this.joined = joined;
	}
}
