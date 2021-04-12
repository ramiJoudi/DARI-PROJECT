package VORTEX.DARIPROJECT.SERVICE;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.REPOSITORY.REPOSITORY_Customer;

@Service
public class SERVICE_Customer {
	@Autowired
	private REPOSITORY_Customer RC;

public void Add_Customer(customer c) {
	// TODO Auto-generated method stub
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(c.getPwd());
	c.setPwd(hashedPassword);
	c.setRole("CUSTOMER");
	RC.save(c);

}
public boolean verify(String verificationCode) {
	customer c = RC.findByVerificationCode(verificationCode);
	
	if (c == null || c.isEnabled()) {
		return false;
	} else {
		c.setVerificationCode(null);
		c.setEnabled(true);
		RC.save(c);
		
		return true;
	}
	
}
 

 
public void Update_Customer( int id,customer c) throws ResourceNotFoundException{
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(c.getPwd());
	customer c1=RC.findById(id).orElseThrow(
			 ()->new ResourceNotFoundException(" this user doesn't exist"));
	c1.setFirstname(c.getFirstname());
	c1.setLasttname(c.getLasttname());
	c1.setMobile(c.getMobile());
	c1.setPwd(hashedPassword);
	c1.setUsername(c.getUsername());
	RC.save(c1);
	
	}


public void Update_CustomerPWD( int id,String pwd) throws ResourceNotFoundException{
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(pwd);
	customer c1=RC.findById(id).orElseThrow(
			 ()->new ResourceNotFoundException(" this user doesn't exist"));
 
	c1.setPwd(hashedPassword);
	RC.save(c1);
	
	}	



public void delete_Customer(int id) {
	 
	RC.deleteById(id);
}


public String Get_Customer(int id) {
	// TODO Auto-generated method stub
	
return	RC.findById(id).get().getUsername();
 
}

public ArrayList<customer> Get_Customers() {
	// TODO Auto-generated method stub
 
	return  (ArrayList<customer>) RC.findAll();
}

public customer findByEmail(String email) {
	
 	return RC.findByEmail(email);
 	}


public customer findByUsername(String username) {
	return RC.findByUsername(username);
}

}
