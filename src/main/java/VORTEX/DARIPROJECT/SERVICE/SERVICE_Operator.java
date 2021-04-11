package VORTEX.DARIPROJECT.SERVICE;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Operator;
import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.REPOSITORY.REPOSITORY_Operator;

@Service
public class SERVICE_Operator {
	
@Autowired
private REPOSITORY_Operator RO;

public void Add_Operator(Operator o) {
	// TODO Auto-generated method stub
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(o.getPwd());
	o.setPwd(hashedPassword);
	o.setRole("OPERATOR");
	RO.save(o);

}

public boolean verify(String verificationCode) {
	Operator o = RO.findByVerificationCode(verificationCode);
	
	if (o == null || o.isEnabled()) {
		return false;
	} else {
		o.setVerificationCode(null);
		o.setEnabled(true);
		RO.save(o);
		
		return true;
	}
	
}
 
public void Update_Operator( int id,Operator o) throws ResourceNotFoundException{
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(o.getPwd());
	Operator o1=RO.findById(id).orElseThrow(
			 ()->new ResourceNotFoundException(" this operator doesn't exist"));
	o1.setFirstname(o.getFirstname());
	o1.setLasttname(o.getLasttname());
	o1.setMobile(o.getMobile());
	o1.setPwd(o.getPwd());
	o1.setUsername(hashedPassword);
	RO.save(o1);
	
	}

public void Update_OperatorPWD( int id,String pwd) throws ResourceNotFoundException{
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(pwd);
	Operator o=RO.findById(id).orElseThrow(
			 ()->new ResourceNotFoundException(" this user doesn't exist"));
 
	o.setPwd(hashedPassword);
	RO.save(o);
	
	}	
	



public void delete_Operator(int id) {
	 
	RO.deleteById(id);
}


public String Get_Operator(int id) {
	// TODO Auto-generated method stub
	
return	RO.findById(id).get().getUsername();
 
}

public ArrayList<Operator> Get_Operators() {
	// TODO Auto-generated method stub
 
	return  (ArrayList<Operator>) RO.findAll();
}

public Operator findByEmail(String email) {
	
 	return RO.findByEmail(email);
 	}


}
