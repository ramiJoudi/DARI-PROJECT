package VORTEX.DARIPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import VORTEX.DARIPROJECT.ENTITY.real_estate;
import VORTEX.DARIPROJECT.Repository.stateRepository;

@Service
public class stateService {
	@Autowired
	public stateRepository rep ;
	
	
	public real_estate save(real_estate real_estate) {
		return rep.save(real_estate);
		
	}
	
	public real_estate getRealstateById(long id) {
		return rep.findById(id).orElse(null);
	}
	
	public String deleteRealstate(long id) {
		rep.deleteById(id);
		return "Realstate removed!!"+id;
	}
	public real_estate updatereal_estate(real_estate Real_estate) {
		real_estate existingRealestate=rep.findById(Real_estate.getStatus()).orElse(null);
		existingRealestate.setLocation(Real_estate.getLocation());
		existingRealestate.setPurchasing_price(Real_estate.getPurchasing_price());
		existingRealestate.setBuy_rent(Real_estate.isBuy_rent());
		return rep.save(Real_estate);
		
	}
	
/*	public ResponseEntity<?> searchstate(String location) {

		return ResponseEntity.ok("Location"+ (List<String>)rep.searchstate(location));


  
  }*/
}
