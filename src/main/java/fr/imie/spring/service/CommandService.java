package fr.imie.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.spring.dao.CommandDAO;
import fr.imie.spring.model.CommandModel;
import fr.imie.spring.model.PanierPlatJoined;
import fr.imie.spring.model.PlatModel;

@Service
public class CommandService {

	@Autowired
	public CommandDAO commandDAO;
	
	@Autowired
	private CommandPlatService commandPlatService;
	
	@Autowired
	private PanierPlatService panierPlatService;

	public void saveCommand(int table) {
		CommandModel cmd = commandDAO.addCommandByTable(table);
		Set<PanierPlatJoined> pan = panierPlatService.getAllPlatByTable(table);
		commandPlatService.saveCommand(cmd, pan);
	}
	
	public List<PlatModel> getPlatCommand(){
		return commandDAO.getPlatCommand();
	}
	
}
