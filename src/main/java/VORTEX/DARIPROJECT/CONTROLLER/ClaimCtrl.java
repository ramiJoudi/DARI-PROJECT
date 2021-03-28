package VORTEX.DARIPROJECT.CONTROLLER;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Claim;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.SERVICE.ResourceNotFoundException;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Claim;

@RestController
public class ClaimCtrl {
	@Autowired
	private SERVICE_Claim S_C;
		
	@GetMapping("/customerHome/addClaim")
	public void addClaim(Claim c) {
		S_C.add_claim(c);
	}
	

	@GetMapping(value = "/customerHome/Claims")
	public ArrayList<Claim> GetClaims(){
	 
		return S_C.get_allClaims();
	}
	@GetMapping("/customerHome/deleteClaim")
	public void deleteClaim(@RequestParam int id)
	{	
		S_C.delete_claim(id);
		}

	@GetMapping(value = "/customerHome/upadteClaim",consumes =MediaType.APPLICATION_JSON_VALUE)
	public void updateClaim(@RequestParam int id,@RequestBody Claim c) throws ResourceNotFoundException{

		S_C.update_claim(id, c);
		
	}
	@GetMapping(value = "/customerHome/claimDetails")
	public Claim GetClaim(@RequestParam int id) {
		 
		return S_C.get_claimByID(id);}
		 

	
}
