package com.bolsadeideas.ejemplos;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/bienvenidos/{colorid}", method=RequestMethod.GET)
	public String holaCasa(ModelMap modelMap, @PathVariable String colorid) {
		logger.info("Bienvenidos a mi casa!");
		logger.info("Colorid: " + colorid);
		logger.info("modelMap: " + modelMap);
		modelMap.addAttribute("color", colorid);
		modelMap.addAttribute("jardin", 1000);
		return "casa";
	}
	
	@RequestMapping(value="/bienvenidosparameters", method=RequestMethod.GET)
	public String holaCasaParameters(ModelMap modelMap, @RequestParam("colorid") String colorid) {
		//http://localhost:8080/ejemplos/bienvenidosparameters?colorid=rosa
		logger.info("Bienvenidos a mi casa!");
		logger.info("Colorid: " + colorid);
		logger.info("modelMap: " + modelMap);
		modelMap.addAttribute("color", colorid);
		modelMap.addAttribute("jardin", 1000);
		return "casa";
	}	
	
}
