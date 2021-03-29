package VORTEX.DARIPROJECT.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.Repository.REPOSITORY_Customer;

@Service
public class SERVICE_Customer2 {
	@Autowired
	private REPOSITORY_Customer RC;

public void Add_Customer(customer c) {
	// TODO Auto-generated method stub
 
/*	c.setRole("CUSTOMER");
	RC.save(c);
*/
}

 
public void Update_Customer( int id,customer c) throws Exception{
	 
	customer c1=RC.findById(id).orElseThrow(
			 ()->new Exception(" this user doesn't exist"));
	c1.setUsername(c.getUsername());
	//c1.setLasttname(c.getLasttname());
	c1.setMobile(c.getMobile());
	c1.setPwd(c.getPwd());
	c1.setUsername(c.getUsername());
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

}
