package VORTEX.DARIPROJECT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import VORTEX.DARIPROJECT.ENTITY.WishList;

import VORTEX.DARIPROJECT.service.WishListService;

@RestController
@RequestMapping("wishlist")
@CrossOrigin("*")
public class WishListController {
	
	@Autowired
    private WishListService service;
	
	@PostMapping("/addwishlist")
	public WishList addwishlist(@RequestBody WishList wishlist) {
		return service.save(wishlist);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletewishlist(@PathVariable int id) {
		return service.deleteWishlist(id);
	}

}
