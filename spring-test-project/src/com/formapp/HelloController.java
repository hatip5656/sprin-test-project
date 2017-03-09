package com.formapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		
		return "hello";

	}
	
	@RequestMapping(value = "/ekle", method = RequestMethod.POST)
	public String ekleresponse(Form form, ModelMap model) throws ClassNotFoundException {
	
		mySqlConnector dbAdd= new mySqlConnector();
		Form v_form=form.get_validated();
		//model.addAttribute("name", v_form.name);
		//model.addAttribute("tc", v_form.tc);
		try{
		if(form.formHata!=true){
		String dbMessage=dbAdd.addTable(form);
		model.addAttribute("bilgi", dbMessage);}
		if(form.formHata==true){
			model.addAttribute("type", "danger");
			model.addAttribute("allert", "YANLIÞ:");
		}else 
			{model.addAttribute("type", "info");
			model.addAttribute("allert", "BÝLGÝ:");}
		
		model.addAttribute("message", v_form.message);
		} catch(Exception ex){
			model.addAttribute("message", "hata oluþtu iþleminiz geçersizdir");
			ex.printStackTrace();
			
		}
		
		return "hello";

	}


}