package fr.imie.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.spring.service.PlatService;

@Controller
public class SamouraiController {

	@Autowired
	public PlatService platService;
	
	@RequestMapping("/")
	public ModelAndView hello(){
		ModelAndView mav = new ModelAndView("hello");
		mav.addObject("msg","hello JSTL !!");
		return mav;
	}
	
	@RequestMapping("/client/{table}")
	public ModelAndView commande(@PathVariable("table") String table){
		ModelAndView mav = new ModelAndView("client");
		mav.addObject("table", table);
		mav.addObject("list", platService.getListePlat());
		return mav;
	}
	
	@RequestMapping("/cuisine")
	public ModelAndView listCommande(){
		ModelAndView mav = new ModelAndView("cuisine");
		return mav;
	}
}
