package VORTEX.DARIPROJECT.CONTROLLER;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
 
import VORTEX.DARIPROJECT.ENTITY.User;
import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.SERVICE.EmailService;
import VORTEX.DARIPROJECT.SERVICE.ResourceNotFoundException;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Admin;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_USER;
import antlr.collections.List;
import net.bytebuddy.utility.RandomString;

@RestController
public class AdminCtrl {
  


@Autowired
private SERVICE_Admin SA;
 
@Autowired
private EmailService emailService;



@RequestMapping("/adminHome")
public ModelAndView  welcome() {return new ModelAndView("HelloAdmin");}


@GetMapping(value = "/adminHome/admins")
public ArrayList<admin> GetAllAdmins(){
 
	return SA.Get_Admins();
}


@GetMapping("/adminHome/deleteAdmin")
public void deleteAdminAccount(@RequestParam int id)
{	
	SA.delete_Admin(id);
	}

@GetMapping(value = "/adminHome/upadteAdmin",consumes =MediaType.APPLICATION_JSON_VALUE)
public void updateAdmin(@RequestParam int id,@RequestBody admin a) throws ResourceNotFoundException{

	SA.Update_Admin(id,a);
	
}
@GetMapping(value = "/adminHome/adminDetails")
public String GetAdmin(@RequestParam int id) {
	 
	return "the username of amdin is"+SA.Get_Admin(id);}
	 


/*
@GetMapping(value="/RegistrationAdmin",consumes =MediaType.APPLICATION_JSON_VALUE)
public void registrationAdmin(@RequestBody admin a) {
	SA.Add_admin((admin)a);
}*/


 
@RequestMapping(value="/singin/admin",method =  RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
public String registrationAdmin(@RequestBody admin a) throws IOException{
	admin existingUser = SA.findByEmail(a.getEmail());
    if(existingUser != null)
    {
        return "This email already exists!";
        
    }
    else
    {
	String randomCode = RandomString.make(64);
	a.setVerificationCode(randomCode);
	a.setEnabled(false);
	SA.Add_Admin(a);

	 SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(a.getEmail());
	    mailMessage.setSubject("Complete Registration!");
//	    mailMessage.setFrom("YOUR EMAIL ADDRESS");
	    mailMessage.setText("To confirm your account, please click here : " 
	    +"http://localhost:81/confirm-account/admin?VerificationCode="+randomCode);

	    emailService.sendEmail(mailMessage);
	    
	 
	return "A verification email has been sent to: "+a.getEmail();

 
    }
    }


@GetMapping(value="/confirm-account/admin")
public String confirmAdminAccount(@RequestParam(value="VerificationCode",required=false)String confirmationToken)
{
	if(SA.verify(confirmationToken))
		 return "account Verified";
	else

    	return "The link is invalid or broken!";
}
}




 