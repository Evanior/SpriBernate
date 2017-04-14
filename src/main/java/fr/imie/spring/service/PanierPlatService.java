package fr.imie.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.spring.dao.PanierPlatDAO;
import fr.imie.spring.model.PanierModel;
import fr.imie.spring.model.PlatModel;

@Service
public class PanierPlatService {

	@Autowired
	private PanierPlatDAO panierPlatDAO;
	
	public void addPlatPanier(PanierModel panier, PlatModel plat){
		panierPlatDAO.addPlatPanier(panier, plat);
	}

	public void removePanierPlat(PanierModel panier, PlatModel plat) {
		panierPlatDAO.removePanierPlat(panier, plat);
	}
}
