package VORTEX.DARIPROJECT.CONTROLLER;

import java.util.ArrayList;

 
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import VORTEX.DARIPROJECT.ENTITY.Operator;
import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.ENTITY.owner;

import VORTEX.DARIPROJECT.SERVICE.EmailService;
import VORTEX.DARIPROJECT.SERVICE.ResourceNotFoundException;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Owner;
import net.bytebuddy.utility.RandomString;

@RestController
public class OwnerCtrl {

	@Autowired
	private SERVICE_Owner SOW;
	@Autowired
	private EmailService emailService;

	
	@RequestMapping("/ownerHome")
	public ModelAndView welcome3() {return new ModelAndView("HelloOwner");}
	

	@GetMapping(value = "ownerHome/Owners")
	public ArrayList<owner> GetAllOwner(){
	 
		return SOW.Get_Owners();}
	
	@DeleteMapping("ownerHome/deleteOwner/{id}")
	public void deleteOwnerAccount(@PathVariable int id)
	{	
		SOW.delete_Owner(id);
		}

	@GetMapping(value="singin/owner")
	public String registrationOwner(@RequestBody owner ow) {
	 
		owner existingUser = SOW.findByEmail(ow.getEmail());
	    if(existingUser != null)
	    {
	        return "This email already exists!";
	        
	    }
	    else
	    {
		String randomCode = RandomString.make(64);
		ow.setVerificationCode(randomCode);
		ow.setEnabled(false);
		SOW.Add_Owner(ow);

		 SimpleMailMessage mailMessage = new SimpleMailMessage();
		    mailMessage.setTo(ow.getEmail());
		    mailMessage.setSubject("Complete Registration!");
//		    mailMessage.setFrom("YOUR EMAIL ADDRESS");
		    mailMessage.setText("To confirm your account, please click here : " 
		    +"http://localhost:81/confirm-account/owner?VerificationCode="+randomCode);

		    emailService.sendEmail(mailMessage);
		    
		 
		return "A verification email has been sent to: "+ow.getEmail();

	 
	    
		 
	}}
	
	@RequestMapping(value="/confirm-account/owner", method= {RequestMethod.GET, RequestMethod.POST})
	public String confirmOwnerAccount(@RequestParam(value="VerificationCode",required=false)String confirmationToken)
	{
		if(SOW.verify(confirmationToken))
			 return "account Verified";
		else

	    	return "The link is invalid or broken!";
	}
	
	
	
	

	@GetMapping(value = "ownerHome/upadteOwner",consumes =MediaType.APPLICATION_JSON_VALUE)
	public void updateOwner(@RequestParam int id,@RequestBody owner ow) throws ResourceNotFoundException{

		SOW.Update_Owner(id,ow);
		
	}
	@GetMapping(value = "ownerHome/ownerDetails")
	public String GetOwner(@RequestParam int id) {
		return "the username of Operator is"+SOW.Get_Owner(id);}

}
