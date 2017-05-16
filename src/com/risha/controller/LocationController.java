package com.risha.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.risha.model.Location;
import com.risha.service.ILocationService;
import com.risha.util.LocationUtil;
import com.risha.validator.LocationValidator;

@Controller
public class LocationController {

	@Autowired
	private ILocationService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private LocationUtil locUtil;
	
	@Autowired
	private LocationValidator validator;
	
	@RequestMapping(value="/locReg",method=RequestMethod.GET)
	public String VendorRegistration(){
		
		return "LocationRegistration";
	}
	
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String insertVendor(@ModelAttribute("location") Location loc,ModelMap map){
		
		
		String error = validator.doValidateLocName(loc.getLocName());
		
		if (error!=null) {
			map.addAttribute("id", error);
		}else {
			int id = service.saveLocation(loc);
			map.addAttribute("id",+id);
		}
		return "LocationRegistration";
	}
	
	@RequestMapping(value="/viewAllLocs",method=RequestMethod.GET)
	public String getAllLocations(ModelMap map){
		List<Location> list = service.getAllLocations();
		map.addAttribute("listObj", list);
		return "LocationData";
	}
	
	@RequestMapping(value="/deleteLoc",method=RequestMethod.GET)
	public String deleteLocation(@RequestParam("locId") int locId){
		
		service.deleteLocation(locId);
		return "redirect:viewAllLocs";
	}
	
	@RequestMapping(value="/editLoc",method=RequestMethod.GET)
	public String getLocationById(@RequestParam("locId") int locId,ModelMap map){
		
		Location locid = service.getLocationById(locId);
		map.addAttribute("locidObj", locid);
		return "LocationDataEdit";
	}
	
	@RequestMapping(value="/updateLoc",method=RequestMethod.POST)
	public String UpdateLocation(@ModelAttribute("location") Location loc) {
		
		service.updateLocation(loc);
		
		return "redirect:viewAllLocs";
	}
	
	@RequestMapping(value="/exportToPdf",method=RequestMethod.GET)
	public String exportToPdf(ModelMap map){
		
		List<Location> list = service.getAllLocations();
		
		map.addAttribute("listObj", list);
		
		return "locPdf";
	}
	
	
	@RequestMapping(value="/singleExport",method=RequestMethod.GET)
	public String exportToPdfSingle(@RequestParam("locId") int locId,ModelMap map){
			
			Location id = service.getLocationById(locId);
			map.addAttribute("idObj", id);
			
		return "locPdfSingle";
	}
	
	
	@RequestMapping(value="exportToExcel",method=RequestMethod.GET)
	public String exportToLocationExcel(ModelMap map){
		
		List<Location> list = service.getAllLocations();
		
		map.addAttribute("listLoc", list);
		
		return "locExcel";
	}
	
	@RequestMapping(value="/locReport")
	public String showReport(){
		
		List<Object[]> data = service.getLocationWiseCount();
		String path = context.getRealPath("/");
		
		locUtil.generatePieLoc(path, data);
		locUtil.generateBarLoc(path, data);
		
		
		return "ReportLoc";
	}
}
