package VORTEX.DARIPROJECT.CONTROLLER;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Claim;

import VORTEX.DARIPROJECT.ENTITY.ClaimType;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.SERVICE.EmailService;
import VORTEX.DARIPROJECT.SERVICE.ResourceNotFoundException;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Claim;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Customer;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_USER;


@RestController
public class ClaimCtrl {
	@Autowired
	private SERVICE_Claim S_C;

	@Autowired
	private SERVICE_Customer SC;
	@Autowired
	private EmailService emailService;
	
	
		
	@GetMapping("/customerHome/addClaim")
	public String addClaim(@RequestBody Claim c,Principal p) throws ResourceNotFoundException {
		String username=p.getName();
		customer client=SC.findByUsername(username);
		c.setClient(client);
		
		if(c.getClaimSubject()==ClaimType.Arnaque) {
			if(existingUser(c.getDescription())) {
				for(Claim claim:S_C.get_allClaims()) {
					 if(claim.getDescription().equals(c.getDescription()) && (client.getId()==claim.getClient().getId()) && claim.getClaimSubject()==ClaimType.Arnaque) {
						return "This claim is already exists!";
					//if(client.getId()==c.getClient().getId() && c.)
					}			 
				}	SingalerCmptArnaque (c.getDescription());
					S_C.add_claim(c);
					return "The Claim is sent successfully";
		
		
	}else 
		return "Enter the username you want to report ";
	 }else if(c.getClaimSubject()==ClaimType.BadWords) {
			if(existingUser(c.getDescription())) {
				for(Claim claim:S_C.get_allClaims()) {
					 if(claim.getDescription().equals(c.getDescription()) && (client.getId()==claim.getClient().getId()) && claim.getClaimSubject()==ClaimType.BadWords) {
						return "This claim is already exists!";
					}			 
				}	SingalerCmptBadWords(c.getDescription());
					S_C.add_claim(c);
					return "The Claim is sent successfully";
		
		
	}else 
		return "Enter the username you want to report ";
	}	else if(c.getClaimSubject()==ClaimType.NotSerious) {
		if(existingUser(c.getDescription())) {
			for(Claim claim:S_C.get_allClaims()) {
				 if(claim.getDescription().equals(c.getDescription()) && (client.getId()==claim.getClient().getId()) && claim.getClaimSubject()==ClaimType.NotSerious) {
					return "This claim is already exists!";
				}			 
			}	SingalerCmptNotSerious(c.getDescription());
				S_C.add_claim(c);
				return "The Claim is sent successfully";
	
	
}else 
	return "Enter the username you want to report ";
		
		} else return "You have to choose the claim subject from Arnaque ,Bad Words or Not Serious";
		}
		public boolean existingUser(String username) {
		if(SC.findByUsername(username)!=null) {
			return true;
		}
		return false;}

	public void SingalerCmptArnaque  (String Username) throws ResourceNotFoundException {
		customer c=SC.findByUsername(Username);
		c.setAsingaler_cmpt(c.getAsingaler_cmpt()+1); 
		if(c.getAsingaler_cmpt()==3) {
			c.getEmail();
			c.setEnabled(false);
			SC.Update_Customer(c.getId(), c);
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
			    mailMessage.setTo(c.getEmail());
			    mailMessage.setSubject("BANNED !!");
//			    mailMessage.setFrom("YOUR EMAIL ADDRESS");
			    mailMessage.setText("You have been banned from DARI application");
			    emailService.sendEmail(mailMessage);
		}
	}
	
	public void SingalerCmptBadWords  (String Username) throws ResourceNotFoundException {
		customer c=SC.findByUsername(Username);
		c.setBsingaler_cmpt(c.getBsingaler_cmpt()+1); 
		if(c.getBsingaler_cmpt()==1) {
			c.getEmail();
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
			    mailMessage.setTo(c.getEmail());
			    mailMessage.setSubject("Alert !!");
//			    mailMessage.setFrom("YOUR EMAIL ADDRESS");
			    mailMessage.setText("Hi sir ,we received a claim about a bad words."+
			    		"two others claims and you will be banned from DARI application");

			    emailService.sendEmail(mailMessage);
		}
		else if(c.getBsingaler_cmpt()==3) {
			c.getEmail();
			c.setEnabled(false); 
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
			    mailMessage.setTo(c.getEmail());
			    mailMessage.setSubject("BANNED !!");
//			    mailMessage.setFrom("YOUR EMAIL ADDRESS");
			    mailMessage.setText("You have been banned from DARI application");

			    emailService.sendEmail(mailMessage);
		}
	}

	public void SingalerCmptNotSerious(String Username) throws ResourceNotFoundException {
		customer c=SC.findByUsername(Username);
		c.setNsingaler_cmpt(c.getNsingaler_cmpt()+1); 
		if(c.getNsingaler_cmpt()==1) {
			c.getEmail();
			SC.Update_Customer(c.getId(), c);
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
			    mailMessage.setTo(c.getEmail());
			    mailMessage.setSubject("Alert !!");
//			    mailMessage.setFrom("YOUR EMAIL ADDRESS");
			    mailMessage.setText("Hi sir ,we received a claim about You're not serious in your dealings. \r\n"
			    		+ "One other claim and you will be banned from DARI");

			    emailService.sendEmail(mailMessage);
		}if(c.getNsingaler_cmpt()==2) {
			c.getEmail();
			c.setEnabled(false); 
			SC.Update_Customer(c.getId(), c);
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
			    mailMessage.setTo(c.getEmail());
			    mailMessage.setSubject("BANNED !!");
//			    mailMessage.setFrom("YOUR EMAIL ADDRESS");
			    mailMessage.setText("You have been banned from DARI application");

			    emailService.sendEmail(mailMessage);
		}
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
		 


	@GetMapping("/customerHome/searchBysubject")
	public List<Claim> searchBysubject(ClaimType ClaimSType){
	return S_C.getClaimsBySubject(ClaimSType);
		//	return S_C.getClaimsBySubject(subject); 
	}

}
