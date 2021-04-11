package VORTEX.DARIPROJECT.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Operator;
import VORTEX.DARIPROJECT.ENTITY.User;
import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.ENTITY.owner;
import VORTEX.DARIPROJECT.SERVICE.EmailService;
import VORTEX.DARIPROJECT.SERVICE.ResourceNotFoundException;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Admin;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Customer;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Operator;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_Owner;
import VORTEX.DARIPROJECT.SERVICE.SERVICE_USER;
import net.bytebuddy.utility.RandomString;

@RestController
public class ResetPwdCtrl {
	
	@Autowired
	private SERVICE_USER SU;
	@Autowired
	private SERVICE_Admin SA;
	@Autowired
	private SERVICE_Customer SC;
	@Autowired
	private SERVICE_Operator SO;
	@Autowired
	private SERVICE_Owner SOw;
	
	
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/login/ResetPwd")
	public String forgotPwd(@RequestParam String username) throws ResourceNotFoundException {
		User u= SU.findByUsername(username);
		String randomCode = RandomString.make(4);
	
		if(u.getRole().equals("ADMIN")) {
			admin a=SA.findByEmail(u.getEmail());
			a.setResetPwdCode(randomCode);
			SA.Update_Admin(a.getId(), a);
		}else if(u.getRole().equals("CUSTOMER")) {
			customer c=SC.findByEmail(u.getEmail());
			c.setResetPwdCode(randomCode);
			SC.Update_Customer(c.getId(), c);
		}
		 SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(u.getEmail());
	    mailMessage.setSubject("Reset password");
//	    mailMessage.setFrom("YOUR EMAIL ADDRESS");
	    mailMessage.setText(randomCode);

	    emailService.sendEmail(mailMessage);
		return "We sent the verification code to your email address " + u.getEmail();
	}
	
	@GetMapping("/login/ResetPwd/code")
	public String verifUserPwdCode(@RequestParam String code,@RequestBody customer c1) throws ResourceNotFoundException {
		User u=SU.findByresetPwdCode(code);
		if(u!=null) {
			if(u.getRole().equals("CUSTOMER")) {
				customer c=SC.findByEmail(u.getEmail());
				SC.Update_CustomerPWD(c.getId(),c1.getPwd());
			}else if(u.getRole().equals("ADMIN")) {
				admin a=SA.findByEmail(u.getEmail());
				SA.Update_AdminPWD(a.getId(), a.getPwd());
			} else if(u.getRole().equals("OPERATOR")) {
				Operator o=SO.findByEmail(u.getEmail());
				SO.Update_OperatorPWD(o.getId(), o.getPwd());
			} else {
				owner ow=SOw.findByEmail(u.getEmail());
				SOw.Update_OwnerPWD(ow.getId(), ow.getPwd());
			}
				return ":)";
		}	else return "Invalid code"; }
	
	 
	
}
