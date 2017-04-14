package fr.imie.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.spring.dao.PanierPlatDAO;
import fr.imie.spring.model.PanierModel;
import fr.imie.spring.model.PanierPlatJoined;
import fr.imie.spring.model.PlatModel;

@Service
public class PanierPlatService {

	@Autowired
	private PanierPlatDAO panierPlatDAO;
	
	@Autowired
	private PanierService panierService;
	
	public void addPlatPanier(PanierModel panier, PlatModel plat){
		panierPlatDAO.addPlatPanier(panier, plat);
	}

	public void removePanierPlat(PanierModel panier, PlatModel plat) {
		panierPlatDAO.removePanierPlat(panier, plat);
	}

	public Set<PanierPlatJoined> getAllPlatByTable(int table) {
		PanierModel pan = panierService.getPanierByTable(table);
		return panierPlatDAO.getAllPlatByTable(pan);
	}
}
