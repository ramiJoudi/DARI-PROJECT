package VORTEX.DARIPROJECT.SERVICE;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Operator;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.ENTITY.owner;
import VORTEX.DARIPROJECT.REPOSITORY.REPOSITORY_Owner;

@Service
public class SERVICE_Owner {
@Autowired
private REPOSITORY_Owner ROw;

public void Add_Owner(owner ow) {
	// TODO Auto-generated method stub
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(ow.getPwd());
	ow.setPwd(hashedPassword);
	ow.setRole("OWNER");
	ROw.save(ow);
}

public boolean verify(String verificationCode) {
	owner ow = ROw.findByVerificationCode(verificationCode);
	
	if (ow == null || ow.isEnabled()) {
		return false;
	} else {
		ow.setVerificationCode(null);
		ow.setEnabled(true);
		ROw.save(ow);
		
		return true;
	}
	
}
 
public void Update_Owner( int id,owner ow) throws ResourceNotFoundException{
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(ow.getPwd());
	owner ow1=ROw.findById(id).orElseThrow(
			 ()->new ResourceNotFoundException(" this admin doesn't exist"));
	ow1.setFirstname(ow.getFirstname());
	ow1.setLasttname(ow.getLasttname());
	ow1.setMobile(ow.getMobile());
	ow1.setPwd(hashedPassword);
	ow1.setUsername(ow.getUsername());
	ROw.save(ow1);
	
	
	}

	



public void delete_Owner(int id) {
	 
	ROw.deleteById(id);
}


public String Get_Owner(int id) {
	// TODO Auto-generated method stub
	
return	ROw.findById(id).get().getUsername();
 
}

public ArrayList<owner> Get_Owners() {
	// TODO Auto-generated method stub
 
	return  (ArrayList<owner>) ROw.findAll();
}
public owner findByEmail(String email) {
	
 	return ROw.findByEmail(email);
 	}

}
