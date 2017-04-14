package fr.imie.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.spring.dao.PlatDAO;
import fr.imie.spring.model.PlatModel;

@Service
public class PlatService {
	
	@Autowired
	public PlatDAO platDAO;
	
	public List<PlatModel> getListePlat(){
		return platDAO.getListePlat();
	}
	
	public PlatModel getPlatByName(String nom){
		return platDAO.getPlatByName(nom);
	}
	
}
