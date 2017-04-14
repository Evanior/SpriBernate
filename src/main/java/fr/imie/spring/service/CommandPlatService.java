package fr.imie.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.spring.dao.CommandPlatDAO;
import fr.imie.spring.model.CommandModel;
import fr.imie.spring.model.PanierPlatJoined;
import fr.imie.spring.model.PlatModel;

@Service
public class CommandPlatService {
	@Autowired
	CommandPlatDAO commandPlatDAO;

	public void saveCommand(CommandModel cmd, Set<PanierPlatJoined> pan) {
		commandPlatDAO.saveCommand(cmd, pan);
	}
	
	public List<PlatModel> getAllCommandPlat() {
		return commandPlatDAO.getAllCommandPlat();
	}

}
