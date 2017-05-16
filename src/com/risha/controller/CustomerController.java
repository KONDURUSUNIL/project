package com.risha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.risha.model.Customer;
import com.risha.service.ICustomerService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	@RequestMapping(value="/custReg",method=RequestMethod.GET)
	public String showCustomerRegistration(){
		
		return "CustomerRegistration";
	}
	
	@RequestMapping(value="/insertcust",method=RequestMethod.POST)
	public String insertCustomer(@ModelAttribute("customer") Customer cust,ModelMap map){
		
		int custId = service.saveCustomer(cust);
		map.addAttribute("custIdObj", custId);
		
		return "CustomerRegistration";
	}
	
	
	@RequestMapping(value="/viewAllCust",method=RequestMethod.GET)
	public String viewAllCustomers(ModelMap map){
		
		List<Customer> list = service.getAllCustomers();
		
		map.addAttribute("listObj", list);
		
		
		return "CustomerData";
	}
	
	@RequestMapping(value="/deletecust",method=RequestMethod.GET)
	public String deleteCustomer(@RequestParam("custId") int custId){
		
		service.deleteCustomer(custId);
		
		return "redirect:viewAllCust";
	}

	@RequestMapping(value="/editcust",method=RequestMethod.GET)
	public String getCustomerById(@RequestParam("custId") int custId,ModelMap map){
		
		Customer custid= service.getCustomerById(custId);
		
		map.addAttribute("custObj", custid);
		
		return "CustomerEditPage";
	}
	
	@RequestMapping(value="/updatecust",method=RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer") Customer cust){
		
		service.updateCustomer(cust);
		
		return "redirect:viewAllCust";
	}
	
	@RequestMapping(value="/exportToCustomerPdf",method=RequestMethod.GET)
	public String exportToCustomerPdf(ModelMap map){
		
		List<Customer> listCustomers = service.getAllCustomers();
		
		map.addAttribute("listcustObj", listCustomers);
		
		return "cusPdf";
	}
	
	@RequestMapping(value="/exportToCustomerSinglePdf",method=RequestMethod.GET)
	public String exportToSingleCustomerPdf(@RequestParam("custId") int custId,ModelMap map){
		
		Customer customerById = service.getCustomerById(custId);
		map.addAttribute("custObj", customerById);
		
		
		return "cusPdfSingle";
	}
	
	@RequestMapping(value="exportToCustomerExcel",method=RequestMethod.GET)
	public String exportToCustomerExcel(ModelMap map){
		
		List<Customer> list = service.getAllCustomers();
		
		map.addAttribute("listcust", list);
		
		return "custExcel";
	}
	

}
