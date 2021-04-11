package VORTEX.DARIPROJECT.CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

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

import VORTEX.DARIPROJECT.ENTITY.User;
import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.SERVICE.EmailService;
import VORTEX.DARIPROJECT.SERVICE.ResourceNotFoundException;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Customer;
import net.bytebuddy.utility.RandomString;

@RestController
public class CustomerCtrl {

@Autowired
private SERVICE_Customer SC; 
@Autowired
private EmailService emailService;
 
@RequestMapping("/customerHome")
public ModelAndView welcome1() {return new ModelAndView("HelloCustomer");}
/*
@GetMapping(value="/RegistrationAdmin",consumes =MediaType.APPLICATION_JSON_VALUE)
public void registrationAdmin(@RequestBody admin a) {
	SA.Add_admin((admin)a);
}*/

@RequestMapping(value="/singin/customer",method =  RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
public String registrationCustomer(@RequestBody customer c) throws IOException{
	customer existingUser = SC.findByEmail(c.getEmail());
    if(existingUser != null)
    {
        return "This email already exists!";
        
    }
    else
    {
	String randomCode = RandomString.make(64);
	c.setVerificationCode(randomCode);
	c.setEnabled(false);
	SC.Add_Customer(c);

	 SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(c.getEmail());
	    mailMessage.setSubject("Complete Registration!");
//	    mailMessage.setFrom("YOUR EMAIL ADDRESS");
	    mailMessage.setText("To confirm your account, please click here : " 
	    +"http://localhost:81/confirm-account/customer?VerificationCode="+randomCode);

	    emailService.sendEmail(mailMessage);
	    
	 
	return "A verification email has been sent to: "+c.getEmail();

 
    }
    }

@GetMapping(value="/confirm-account/customer")
public String confirmAdminAccount(@RequestParam(value="VerificationCode",required=false)String confirmationToken)
{
	if(SC.verify(confirmationToken))
		 return "account Verified";
	else

    	return "The link is invalid or broken!";
}


@GetMapping(value = "/customerHome/customers")
public ArrayList<customer> GetCustomer(){
 
	return SC.Get_Customers();
}
@GetMapping("/customerHome/deleteCustomer")
public void deleteCustomer(@RequestParam int id)
{	
	SC.delete_Customer(id);
	}

@GetMapping(value = "/customerHome/upadteCustomer",consumes =MediaType.APPLICATION_JSON_VALUE)
public void updateCustomer(@RequestParam int id,@RequestBody customer c) throws ResourceNotFoundException{

	SC.Update_Customer(id, c);
	
}



@GetMapping(value = "/customerHome/customerDetails")
public String GetAdmin(@RequestParam int id) {
	 
	return "the username of Customer is"+SC.Get_Customer(id);}
	 

 
}
