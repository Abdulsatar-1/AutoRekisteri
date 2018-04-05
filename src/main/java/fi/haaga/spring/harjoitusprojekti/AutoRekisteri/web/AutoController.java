package fi.haaga.spring.harjoitusprojekti.AutoRekisteri.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain.Auto;
import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain.AutoRepository;
import fi.haaga.spring.harjoitusprojekti.AutoRekisteri.domain.PolttoaineRepository;



@Controller
//@ResponseBody
public class AutoController {

	@Autowired
	private AutoRepository repository;
	
	@Autowired
	private PolttoaineRepository prepository; 
	
	@RequestMapping(value="/autolist", method=RequestMethod.GET)
	public String autot(Model model) {
		model.addAttribute("auto", repository.findAll());
		return "autolist";
	}
	
	// RESTful service to get all books
	   @RequestMapping(value="/autot", method = RequestMethod.GET)
	   public @ResponseBody List<Auto> autoListRest(){	
	        return (List<Auto>) repository.findAll();
	    }    
	   
	// RESTful service to get student by id
	    @RequestMapping(value="/autot/{id}", method = RequestMethod.GET)
	    public @ResponseBody Auto findAutoRest(@PathVariable("id") Long autoId) {	
	    	return repository.findOne(autoId);
	    }         
	
	
	@RequestMapping(value = "/add")
	public String addAuto(Model model){
	model.addAttribute("auto", new Auto());
	model.addAttribute("polttoaine", prepository.findAll());
	return "addauto";
	} 
	@RequestMapping(value="/addauto", method=RequestMethod.POST)
	public String addAuto(Auto auto) {
		repository.save(auto);
		return "redirect:/autolist";
	}
	
	@RequestMapping(value = "/editauto/{id}", method = RequestMethod.GET)
	public String editAuto(@PathVariable("id") Long autoId, Model model) {
		model.addAttribute("auto", repository.findOne(autoId));
		model.addAttribute("polttoaine", prepository.findAll());
	return "editauto";
	}
	
	@RequestMapping(value="/editauto/editauto", method=RequestMethod.POST)
	public String editAuto(Auto auto) {
		repository.save(auto);
		return "redirect:/autolist";
	}
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteAuto(@PathVariable("id") Long autoId, Model model) {
	repository.delete(autoId);
	return "redirect:/autolist";
	}

	@RequestMapping(value="/login")
		public String login(){
		return "login";
	}
}


