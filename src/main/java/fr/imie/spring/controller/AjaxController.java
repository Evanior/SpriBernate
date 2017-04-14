package fr.imie.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.spring.model.AjaxResponseModel;
import fr.imie.spring.model.PanierPlatJoined;
import fr.imie.spring.model.PlatModel;
import fr.imie.spring.service.PanierService;
import fr.imie.spring.service.PlatService;

@Controller
public class AjaxController {
	
	@Autowired
	private PlatService platService;
	@Autowired
	private PanierService panierService;
	
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
	@RequestMapping("/panier/{table}/add/{plat}")
	public AjaxResponseModel<PlatModel> addPanierByTable(@PathVariable("table") int table,
			@PathVariable("plat") String plat) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		panierService.addPlatPanier(table, plat);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping("/panier/{table}/remove")
	public AjaxResponseModel<PlatModel> removePanierByTable(@PathVariable("table") int table) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		panierService.removePanierByTable(table);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping("/panier/{table}/submit")
	public AjaxResponseModel<PlatModel> submitPanierByTable(@PathVariable("table") String table) {
		AjaxResponseModel<PlatModel> resp = new AjaxResponseModel<>();
		return resp;
	}
	
}
