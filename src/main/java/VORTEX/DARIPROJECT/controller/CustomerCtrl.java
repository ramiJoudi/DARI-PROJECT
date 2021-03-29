package VORTEX.DARIPROJECT.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import VORTEX.DARIPROJECT.ENTITY.User;
 
import VORTEX.DARIPROJECT.ENTITY.customer;
import VORTEX.DARIPROJECT.Repository.REPOSITORY_Customer;

@RestController
@RequestMapping("api")
public class CustomerCtrl {

	/*
@Autowired
private customer SC;
*/
@Autowired
private  REPOSITORY_Customer cu ;

@GetMapping
public List<customer> customeraall() {
 	
	return (List<customer>) cu.findAll();
}
 
@RequestMapping("/customerHome")
public ModelAndView welcome1() {return new ModelAndView("HelloCustomer");}
/*
 * 
 * 
@GetMapping(value="/RegistrationAdmin",consumes =MediaType.APPLICATION_JSON_VALUE)
public void registrationAdmin(@RequestBody admin a) {
	SA.Add_admin((admin)a);
}*/
/*
@GetMapping(value = "/customerHome/customers")
public ArrayList<customer> GetCustomer(){
 
	return SC.getc();
}*/
/*
@DeleteMapping("/customerHome/deleteCustomer/{id}")
public void deleteCustomer(@PathVariable int id)
{	
	SC.delete_Customer(id);
	}
*/
/*
@GetMapping(value="/singin/customer",consumes =MediaType.APPLICATION_JSON_VALUE)
public void registrationCustomer(@RequestBody customer c) {
	 
	SC.Add_Customer(c);
 
}*/
/*
@GetMapping(value = "/customerHome/upadteCustomer",consumes =MediaType.APPLICATION_JSON_VALUE)
public void updateAdmin(@RequestParam int id,@RequestBody customer c) throws Exception{

	SC.Update_Customer(id, c);
	
}
@GetMapping(value = "/customerHome/customerDetails")
public String GetAdmin(@RequestParam int id) {
	 
	return "the username of Customer is"+SC.Get_Customer(id);}
	 

}*/ 
}
