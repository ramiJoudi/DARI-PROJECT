package VORTEX.DARIPROJECT.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Deposit_of_guarantees;
import VORTEX.DARIPROJECT.service.DepositService;
import VORTEX.DARIPROJECT.service.Service;
import VORTEX.DARIPROJECT.service.TwilioSmsSender;
import VORTEX.DARIPROJECT.service.ValidateMail;
import VORTEX.DARIPROJECT.service.SmsRequest;


@RestController
@RequestMapping("deposit")
//@CrossOrigin("*")
public class DepositController {
	
 
	@Autowired
    private DepositService service;
	@Autowired
	private  Service ng ;
	@Autowired
	private ValidateMail vlm ;
	
	@PostMapping("/addeposit")
	
	public Deposit_of_guarantees addeposit(@RequestBody Deposit_of_guarantees deposit ) {
		 if(vlm.validateEmail(deposit.getAdressMail()))
		 {
	   
		ng.sendSms(new SmsRequest( deposit.getPhoneNumber()));
		 
		return service.save(deposit) ;
		 }else return null;
		
	}
	
	@GetMapping("/deposit/{id}")
	public Deposit_of_guarantees findById(@PathVariable int id) {
		return service.getdepositById(id);
	}
	
	@PutMapping("/update")
	public Deposit_of_guarantees updatedeposit(@RequestBody Deposit_of_guarantees deposit) {
		return service.updaterdeposit(deposit);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletedeposit(@PathVariable int id) {
		return service.deletedeposit(id);
	}
	
	
	



}
