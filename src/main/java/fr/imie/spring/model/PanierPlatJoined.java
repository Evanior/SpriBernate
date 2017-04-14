package fr.imie.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="panier_plat")
public class PanierPlatJoined {
	
	@Id
	@GeneratedValue(generator="keygen")
	@GenericGenerator(strategy="increment", name = "keygen")
	@Column(name="id_panier_plat")
	private int id_panier_plat;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="id_panier")
    private PanierModel panier;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="id_plat")
    private PlatModel plat;
    
    @Column(name="quantite")
    private int quantite;

	public int getId_panier_plat() {
		return id_panier_plat;
	}

	public void setId_panier_plat(int id_panier_plat) {
		this.id_panier_plat = id_panier_plat;
	}

	public PanierModel getPanier() {
		return panier;
	}

	public void setPanier(PanierModel panier) {
		this.panier = panier;
	}

	public PlatModel getPlat() {
		return plat;
	}

	public void setPlat(PlatModel plat) {
		this.plat = plat;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
