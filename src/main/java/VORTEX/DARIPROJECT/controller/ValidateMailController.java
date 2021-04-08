package VORTEX.DARIPROJECT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.service.ValidateMail;

class TestMail  {
	
	String mail ;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public TestMail(String mail) {
		super();
		this.mail = mail;
	}

	public TestMail() {
		super();
	}
	
}
@RestController
@RequestMapping("api")
@CrossOrigin("*")

public class ValidateMailController {
	
	@Autowired
	private ValidateMail vlm ;
	
	@PostMapping("/validateEmail")
	public @ResponseBody ResponseEntity<?>  testMail(@RequestBody  TestMail tm )
	{
		
		 if(vlm.validateEmail(tm.getMail())) {
			 
			 return ResponseEntity.status(HttpStatus.OK).body("email juste");
		 }
		
		 else   return ResponseEntity.status(HttpStatus.OK).body("email false");
		
	}
	
	

}
