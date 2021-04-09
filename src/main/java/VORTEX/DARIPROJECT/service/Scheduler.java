package VORTEX.DARIPROJECT.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import VORTEX.DARIPROJECT.ENTITY.WishList;
import VORTEX.DARIPROJECT.ENTITY.real_estate;
import VORTEX.DARIPROJECT.Repository.WishListrepo;
import VORTEX.DARIPROJECT.Repository.stateRepository;



@Component
public class Scheduler {
	@Autowired
	WishListrepo wish ;
	
	@Autowired
	stateRepository  srepo;
	
   @Scheduled(fixedDelay = 1000, initialDelay = 1000*60*60*24)
   public void fixedDelaySch() {
    
      if(!wish.findAll().equals(null))
      for(real_estate rs  :  srepo.findAll()) {
    	
    	  
    	  rs.setWishlist(null);
    	  
    	  srepo.save(rs);
    	  
    	  
    	  
      }
   }
}