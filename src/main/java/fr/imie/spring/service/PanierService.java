package fr.imie.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.spring.dao.PanierDAO;
import fr.imie.spring.model.PanierModel;
import fr.imie.spring.model.PlatModel;

@Service
public class PanierService {

	@Autowired
	public PanierDAO panierDAO;
	
	@Autowired
	private PlatService platService;
	
	@Autowired
	private PanierPlatService panierPlatService;
	
	public List<PanierModel> getListeCmd(){
		return panierDAO.getListeCmd();
	}

	public List<PlatModel> getPlatByTable(int table) {
		return panierDAO.getPlatByTable(table);
	}
	
	public PanierModel getPanierByTable(int table){
		return panierDAO.getPanierByTable(table);
	}
	
	public void addPlatPanier(int table, String plat){
		PlatModel p = platService.getPlatByName(plat);
		if(p != null){
			PanierModel pan = panierDAO.addPanierByTable(table);
			panierPlatService.addPlatPanier(pan, p);
		}
	}
	
	public void removePanierByTable(int table){
		panierDAO.removePanierByTable(table);
	}
}
