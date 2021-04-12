package VORTEX.DARIPROJECT.SERVICE;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Claim;

import VORTEX.DARIPROJECT.ENTITY.ClaimType;

import VORTEX.DARIPROJECT.REPOSITORY.REPOSITORY_Claim;

@Service
public class SERVICE_Claim {

	@Autowired
	private REPOSITORY_Claim Rclaim;
	
	
	public void add_claim(Claim c) {
		Rclaim.save(c);
	}
	
	public Claim get_claimByID(int id) {
		// TODO Auto-generated method stub
	return	Rclaim.findById(id).get();
	}
	public void update_claim( int id,Claim c)  throws ResourceNotFoundException{
		 Claim c1=Rclaim.findById(id).orElseThrow(
				 ()->new ResourceNotFoundException(" this claim doesn't exist"));

	 
		c1.setClaimSubject(c.getClaimSubject());

		c1.setDescription(c.getDescription());
		 Rclaim.save(c1);
	}
	
	public void delete_claim(int id) {
		Rclaim.deleteById(id);

	}
	
	public ArrayList<Claim> get_allClaims() {
		// TODO Auto-generated method stub
		return  (ArrayList<Claim>) Rclaim.findAll();
	}
	

	public List<Claim> getClaimsBySubject(ClaimType claimSubject){
		return Rclaim.getByClaimSubject(claimSubject);
	}

	

}
