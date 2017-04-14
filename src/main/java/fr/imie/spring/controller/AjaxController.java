package fr.imie.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.spring.model.AjaxResponseModel;
import fr.imie.spring.model.PlatModel;
import fr.imie.spring.service.CommandPlatService;
import fr.imie.spring.service.CommandService;
import fr.imie.spring.service.PanierService;
import fr.imie.spring.service.PlatService;

@Controller
public class AjaxController {
	
	@Autowired
	private PlatService platService;
	@Autowired
	private PanierService panierService;
	@Autowired
	private CommandService commandService;
	@Autowired
	private CommandPlatService commandPlatService;
	
	@ResponseBody
	@RequestMapping("/plats/list")
	public AjaxResponseModel<PlatModel> getToutPlats() {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		resp.setData(platService.getListePlat());
		return resp;
	}
	
	@ResponseBody
	@RequestMapping("/panier/{table}")
	public AjaxResponseModel<PlatModel> getPanierByTable(@PathVariable("table") int table) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		List<PlatModel> list = panierService.getPlatByTable(table);
		if(list.isEmpty()){
			return resp;
		}
		//List<PlatModel> list = new ArrayList<PlatModel>(set);
		resp.setData(list);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value="/panier/{table}/add/{plat}",method=RequestMethod.POST)
	public AjaxResponseModel<PlatModel> addPanierByTable(@PathVariable("table") int table,
			@PathVariable("plat") String plat) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		panierService.addPlatPanier(table, plat);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value="/panier/{table}/remove",method=RequestMethod.POST)
	public AjaxResponseModel<PlatModel> removePanierByTable(@PathVariable("table") int table) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		panierService.removePanierByTable(table);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value="/panier/{table}/remove/{plat}",method=RequestMethod.POST)
	public AjaxResponseModel<PlatModel> removePlatPanierByTable(@PathVariable("table") int table,
			@PathVariable("plat") String plat) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		panierService.removePlatPanierByTable(table, plat);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value="/panier/{table}/submit",method=RequestMethod.POST)
	public AjaxResponseModel<PlatModel> submitPanierByTable(@PathVariable("table") int table) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		commandService.saveCommand(table);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping("/command")
	public AjaxResponseModel<PlatModel> getAllPlatCommand() {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		List<PlatModel> list = commandService.getPlatCommand();	//commandPlatService.getAllCommandPlat();
		if(list.isEmpty()){
			return resp;
		}
		resp.setData(list);
		return resp;
	}
	
}
