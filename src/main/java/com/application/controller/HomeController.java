package com.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.database.Product;
import com.application.database.ProductImplementationService;

/**
 * @author Syambrij M 
 * A Controller page for login and product List page.
 * There are some duplicate methods left intentionally. 
 * You can get rid of them whenever accordingly with your 
 * choices to use Get/Post Method.
 */

@Controller
public class HomeController {
	
	@Autowired
	private ProductImplementationService productService;  
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView first() {
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/login");
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView firstPost() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error == null) {
			model.addObject("error", "Invalid username and password!");
			model.setViewName("error");
			return model;
		}
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView homeGet() {
		ModelAndView model = new ModelAndView();
		model.addObject("message" , "Welcome to new destination");
		model.setViewName("home");
		return model;
	}
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public ModelAndView homePost() {
		ModelAndView model = new ModelAndView();
		model.addObject("message" , "Welcome to new destination");
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView admin() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		return model;		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String login(HttpServletRequest request , HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){   
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/login";
	/*	HttpSession session = request.getSession();
		session.invalidate();
		return "logout";*/
	}
	
	@RequestMapping(value="/error", method=RequestMethod.POST)
	public ModelAndView product() {
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		return model;
	}
	
	@RequestMapping(value="/productcreated", method=RequestMethod.POST)
	public String message(@ModelAttribute("productData") Product product, BindingResult result, ModelMap model){
		if (result.hasErrors()) {
			model.addAttribute("error", result.getAllErrors().get(0));
	        return "error";
	    }
		productService.add(product);  
		return "productcreated";	
	}
	
	@RequestMapping(value="/products", method =RequestMethod.POST)
	 public ModelAndView listProducts() {		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("products");
		List<Product> products = productService.getAll();
		model.addObject("products" , products.subList(0, 40));   
		return model;
	}
	@RequestMapping(value="/products", method =RequestMethod.GET)
	 public ModelAndView listProductsGet() {		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("products");
		List<Product> products = productService.getAll();
		model.addObject("products" , products.subList(0, 40));   
		return model;
	}
	
	@Bean(name = "shaPasswordEncoder")
	public ShaPasswordEncoder shaPasswordEncoder(){
		return new ShaPasswordEncoder(256);
	}
	
	@Bean(name = "reflectionSaltSource")
	public ReflectionSaltSource reflectionSaltSource(){
		ReflectionSaltSource source = new ReflectionSaltSource();
		source.setUserPropertyToUse("id");
		return source;
	}
}
