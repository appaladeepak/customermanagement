package com.example.ProductManagement.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.ProductManagement.implementation.Customerimplementation;
import com.example.ProductManagement.implementation.UserImplementation;
import com.example.ProductManagement.model.Customers;
import com.example.ProductManagement.model.User;

@Controller
public class CustomerController {

	@Autowired
	private Customerimplementation customerImplementation;
	@Autowired
	private UserImplementation userImplementation;
	@GetMapping("/home")
	public String getHome(Model model) {
		List<Customers> listCustomers=customerImplementation.getCustomers();
		System.out.println(listCustomers.get(0));
		model.addAttribute("listCustomers", listCustomers);
		return "customers";
	}
	
	@RequestMapping("/new")
	public String showNewCustomerForm(Model model) {
		Customers p=new Customers();
		model.addAttribute("customer", p);
		return "new_customer";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveNewCustomer(@ModelAttribute("customer") Customers customer) {
		customerImplementation.saveCustomers(customer);
		
		return "redirect:/home";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView EditCustomer(@PathVariable(name="id") int id) {
		ModelAndView mav=new ModelAndView("edit_customer");
		Customers customer= customerImplementation.getCustomer(id);
		mav.addObject("customer",customer);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String DeleteCustomer(@PathVariable(name="id") int id) {
		customerImplementation.deleteCustomerById(id);
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	public ModelAndView Login() {
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("user",new User());
		return mav;
	}
	
	@PostMapping("/login")
	public String Login(@ModelAttribute("user") User user) {
		User auhuser=userImplementation.login(user.getUsername(), user.getPassword());
		System.err.println(auhuser+user.getUsername()+user.getPassword());
		if(Objects.nonNull(auhuser)) {
			return "redirect:/home";
		}else {
			return "redirect:/login";
		}
		//return null;
		
	}
}
