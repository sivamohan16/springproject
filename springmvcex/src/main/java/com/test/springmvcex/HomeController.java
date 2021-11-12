package com.test.springmvcex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@Autowired
	private Fruitservice service;
	
	@RequestMapping("/")
	public String home () {

		return "index.jsp";
	}
    @RequestMapping("/admin") public String adminpage(){
		return "adminlogin.jsp";
	}

	@RequestMapping ("/login")
	public String view (@ModelAttribute("username") String username, @ModelAttribute("password") String password)
	{
		if((username.equals("aa")) && (password.equals("111")))
        {
        	
        
		return "redirect:/listfruits";
        }
		else
		{
		return "redirect: /admin" ;
		}
		}
		
		@RequestMapping("/listfruits") 
		public String getAll(Model m)
		{
			List<Fruit> lists = service.getAllFruit();
			m.addAttribute("fruitlist", lists);
			return "fruitview.jsp";
		}
		
		@RequestMapping("/deletebyid/{id}")
		public ModelAndView delete (@PathVariable("id") int id)
		{
		   service.deleteFruit(id);

			return new ModelAndView("redirect:/listfruits");

		}
		
		@RequestMapping("/addnew")
		public String addnewrow()
		{
          return "addform.jsp";
		}
		
		@RequestMapping(value="/save", method = RequestMethod.POST)
		public ModelAndView saveFruit(@ModelAttribute Fruit fruit)
		{
			service.saveOrUpdate(fruit);
			
			return new ModelAndView("redirect:/listfruits");
		}		
}
