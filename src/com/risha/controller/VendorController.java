package com.risha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.risha.model.Location;
import com.risha.model.Vendor;
import com.risha.service.IVendorService;
import com.risha.util.LocationUtil;

@Controller
public class VendorController {

	@Autowired
	private IVendorService service;
	
	@Autowired
	private LocationUtil locUtil;
	
	
	
	
	@RequestMapping(value="/venReg",method=RequestMethod.GET)
	public String showVendorRegistrationPage(ModelMap map){
		
		List<Location> locList = locUtil.getAllLocations();
		map.addAttribute("locListObj", locList);
		return "VendorRegistration";
	}
	
	@RequestMapping(value="/insertVen",method=RequestMethod.POST)
	public String insertVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap map){
		
		
		int id = service.saveVendor(vendor);
		map.addAttribute("vendor is save with id:",+id);
		
		List<Location> locList = locUtil.getAllLocations();
		map.addAttribute("locListObj", locList);
		
		return "VendorRegistration";
	}
	
	@RequestMapping(value="/viewAllVen",method=RequestMethod.GET)
	public String getAllVendors(ModelMap map){
		
		List<Vendor> list = service.getAllVendors();
		map.addAttribute("vendorObj",list);
		
		return "VendorsData";
		
	}

	@RequestMapping(value="/deleteVen",method=RequestMethod.GET)
	public String deleteVendor(@RequestParam("id") int id){
		
		service.deleteVendor(id);
		
		return "redirect:viewAllVen";
	}
	
	
	@RequestMapping(value="/editVen",method=RequestMethod.GET)
	public String showEditPage(@RequestParam("id") int id,ModelMap map){
		
		List<Location> locList = locUtil.getAllLocations();
		map.addAttribute("locListObj", locList);
		
		Vendor venid = service.getVendorById(id);
		map.addAttribute("venid", venid);
		return "VendorEditPage";
	}
	
	
	@RequestMapping(value="/updateVen",method=RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap map){
		
		service.updateVendor(vendor);
		
		
		return "redirect:viewAllVen";
	}
	
	
	@RequestMapping(value="/exportToVendorPdf",method=RequestMethod.GET)
	public String exportToPdf(ModelMap map){
		
		List<Vendor> listVenObj = service.getAllVendors();
		map.addAttribute("listVenObj", listVenObj);
		
		return "venPdf";
	}
	
	@RequestMapping(value="/exportToVendorSinglePdf",method=RequestMethod.GET)
	public String exportToSinglePdf(@RequestParam("id") int id,ModelMap map){
		
		Vendor vendorById = service.getVendorById(id);
		
		map.addAttribute("venById", vendorById);
		
		return "venPdfSingle";
	}
	
	@RequestMapping(value="exportToVendorExcel",method=RequestMethod.GET)
	public String exportToVendorExcel(ModelMap map){
		
		List<Vendor> list = service.getAllVendors();
		
		map.addAttribute("listVen", list);
		
		
		return "venExcel";
	}
	
	
	
	
}
