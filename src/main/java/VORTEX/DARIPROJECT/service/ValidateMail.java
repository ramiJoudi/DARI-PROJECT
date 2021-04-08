package VORTEX.DARIPROJECT.service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Service;

@Service
public class ValidateMail {
	
	private boolean isValid = false ;
	
public boolean validateEmail(String email ) {
		
		
		isValid = crunchifyEmailValidator(email);
		
		
		return isValid;
		 
		
		
	}

	private boolean crunchifyEmailValidator(String email) {
		boolean isValid = false;
		try {
			//
			// Create InternetAddress object and validated the supplied
			// address which is this case is an email address.
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
		} catch (AddressException e) {
			System.out.println("You are in catch block -- Exception Occurred for: " + email);
		}
		return isValid;
	}

}
