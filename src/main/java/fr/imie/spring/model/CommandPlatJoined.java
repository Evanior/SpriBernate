package fr.imie.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="command_plat")
public class CommandPlatJoined {
	
	@Id
	@GeneratedValue(generator="keygen")
	@GenericGenerator(strategy="increment", name = "keygen")
	@Column(name="id_command_plat")
	private int id;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="id_command")
    private CommandModel command;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="id_plat")
    private PlatModel plat;
    
    @Column(name="quantite")
    private int quantite;

	public int getId() {
		return id;
	}

	public void setId(int id_command_plat) {
		this.id = id_command_plat;
	}

	public CommandModel getCommand() {
		return command;
	}

	public void setCommand(CommandModel commands) {
		this.command = command;
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
