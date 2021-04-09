package VORTEX.DARIPROJECT.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import VORTEX.DARIPROJECT.ENTITY.WishList;
import VORTEX.DARIPROJECT.ENTITY.real_estate;
import VORTEX.DARIPROJECT.Repository.WishListrepo;
import VORTEX.DARIPROJECT.Repository.stateRepository;
import VORTEX.DARIPROJECT.service.WishListService;

@RestController
@RequestMapping("wishlist")
public class WishListController {
	
	@Autowired
    private WishListService service;
	
	@Autowired
	private  WishListrepo wishrep;
	
	@Autowired
	private stateRepository srep;
	
	@PostMapping("/addwishlist")
	public WishList addwishlist(@RequestBody WishList wishlist) {
		return service.save(wishlist);
	}
	
	@GetMapping("/Getwishlist")
	public List<Map<String, Object>> findById() {
		
		
		 List<Map<String, Object>>  al = new ArrayList<>();
		 
		 for(WishList w  :  wishrep.findAll()) {
			 Map<String, Object>  ml = new HashMap<>();
			 ml.put("Area", w.getArea());
			 ml.put("NbGarage", w.getNbGarage());
			 ml.put("Location", w.getLocation());
			 ml.put("Nbgarage", w.getNbGarage());
			 ml.put("NbRooms", w.getNbRooms());
			 ml.put("Price", w.getPrice());
			 ml.put("Elevator", w.isElevator());
			 ml.put("Basement", w.isBasement());
			 ml.put("Garde", w.isGarde());
			 ml.put("Heater", w.isHeater());
			 ml.put("Meuble", w.isMeuble());
			 ml.put("Piscine", w.isPiscine());
			 ml.put("Terrase", w.isTerrase());
			 ml.put("AirConditionnig", w.isAirConditionnig());
			List<real_estate> rs = new ArrayList<>();
			 for(real_estate u  :  w.getReal_estate()) {
				 
				 if(u.getWishlist().equals(null)) {
					 System.out.println("wishlist vide");
				 }
				 else rs.add(u);
			 }
			 if(rs.isEmpty()==false)
				  ml.put("realstate",rs);
			 
			 
			 al.add(ml);
			 
			 
			 
			 
			 
		 }
		return al ;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletewishlist(@PathVariable int id) {
		return service.deleteWishlist(id);
	}

}
