package VORTEX.DARIPROJECT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import VORTEX.DARIPROJECT.ENTITY.WishList;
import VORTEX.DARIPROJECT.ENTITY.real_estate;
import VORTEX.DARIPROJECT.Repository.WishListrepo;

@Service
public class WishListService {
	@Autowired
    public WishListrepo wl;
	
	public WishList save(WishList WishList) {
		return wl.save(WishList);
	}
	public String deleteWishlist(int id) {
		wl.deleteById(id);
		return "Realstate removed!!"+id;
	}
	


}
