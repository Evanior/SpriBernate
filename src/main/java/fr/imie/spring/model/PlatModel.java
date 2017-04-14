package fr.imie.spring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy="plat", targetEntity=PanierPlatJoined.class)
	private Set<PanierPlatJoined> joinedPanier;
	
	@OneToMany(mappedBy="plat", targetEntity=CommandPlatJoined.class)
	private Set<PanierPlatJoined> joinedCommands;
	
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
	
	public Set<PanierPlatJoined> getJoined() {
		return joinedPanier;
	}

	public void setJoined(Set<PanierPlatJoined> joined) {
		this.joinedPanier = joined;
	}
	public Set<PanierPlatJoined> getJoinedPanier() {
		return joinedPanier;
	}
	public void setJoinedPanier(Set<PanierPlatJoined> joinedPanier) {
		this.joinedPanier = joinedPanier;
	}
	public Set<PanierPlatJoined> getJoinedCommands() {
		return joinedCommands;
	}
	public void setJoinedCommands(Set<PanierPlatJoined> joinedCommands) {
		this.joinedCommands = joinedCommands;
	}
	
	
}
