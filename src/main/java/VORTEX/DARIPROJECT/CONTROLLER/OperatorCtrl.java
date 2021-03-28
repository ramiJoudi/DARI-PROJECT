package VORTEX.DARIPROJECT.CONTROLLER;

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

import VORTEX.DARIPROJECT.ENTITY.Operator;
import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.SERVICE.EmailService;
import VORTEX.DARIPROJECT.SERVICE.ResourceNotFoundException;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Operator;
import net.bytebuddy.utility.RandomString;

@RestController
public class OperatorCtrl {
	
	@Autowired
	private SERVICE_Operator SOP;
	@Autowired
	private EmailService emailService;
 
 
	
	@RequestMapping("/operatorHome")
	public ModelAndView welcome2() {return new ModelAndView("HelloOperator");}
	
	@GetMapping(value = "/operatorHome/operators")
	public ArrayList<Operator> GetAllOperators(){
	 
		return SOP.Get_Operators();
	}
	
	@GetMapping("/operatorHome/deleteOperator/{id}")
	public void deleteOperatorAccount(@PathVariable int id)
	{	
		SOP.delete_Operator(id);
		}

	@GetMapping(value = "/operatorHome/updateOperator/{id}",consumes =MediaType.APPLICATION_JSON_VALUE)
	public void updateOperator(@PathVariable int id,@RequestBody Operator op) throws ResourceNotFoundException{

		SOP.Update_Operator(id,op);
		
	}
	@GetMapping(value = "/operatorHome/operatorDetails")
	public String GetOperator(@RequestParam int id) {
		 
		return "the username of Operator is"+SOP.Get_Operator(id);}

	@GetMapping(value="/singin/operator")
	public String registrationOperator(@RequestBody Operator op) {

		Operator existingUser = SOP.findByEmail(op.getEmail());
	    if(existingUser != null)
	    {
	        return "This email already exists!";
	        
	    }
	    else
	    {
		String randomCode = RandomString.make(64);
		op.setVerificationCode(randomCode);
		op.setEnabled(false);
		SOP.Add_Operator(op);

		 SimpleMailMessage mailMessage = new SimpleMailMessage();
		    mailMessage.setTo(op.getEmail());
		    mailMessage.setSubject("Complete Registration!");
//		    mailMessage.setFrom("YOUR EMAIL ADDRESS");
		    mailMessage.setText("To confirm your account, please click here : " 
		    +"http://localhost:81/confirm-account/operator?VerificationCode="+randomCode);

		    emailService.sendEmail(mailMessage);
		    
		 
		return "A verification email has been sent to: "+op.getEmail();

	 
	    }
	}
	
	@RequestMapping(value="/confirm-account/operator", method= {RequestMethod.GET, RequestMethod.POST})
	public String confirmAdminAccount(@RequestParam(value="VerificationCode",required=false)String confirmationToken)
	{	
		if(SOP.verify(confirmationToken))
			 return "account Verified";
		else

	    	return "The link is invalid or broken!";
	}

}
