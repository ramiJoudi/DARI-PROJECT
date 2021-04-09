package VORTEX.DARIPROJECT.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import VORTEX.DARIPROJECT.ENTITY.Deposit_of_guarantees;
import VORTEX.DARIPROJECT.service.DepositService;
import VORTEX.DARIPROJECT.service.Service;
import VORTEX.DARIPROJECT.service.TwilioSmsSender;
import VORTEX.DARIPROJECT.service.ValidateMail;
import VORTEX.DARIPROJECT.service.SmsRequest;


@RestController
@RequestMapping("deposit")

public class DepositController {
	
 
	@Autowired
    private DepositService service;
	@Autowired
	private  Service ng ;
	@Autowired
	private ValidateMail vlm ;
	
	
	private byte[] img1 ;
	
	private byte[] img2 ;
	private byte[] img3 ;
	@PostMapping("/upload")
	
	public void uploadiMAge(@RequestParam("imageFile1") MultipartFile image1,@RequestParam("imageFile2") MultipartFile image2,@RequestParam("imageFile3") MultipartFile image3) throws IOException {
	   this.img1 = image1.getBytes();
	   this.img2 = image2.getBytes();
	   this.img3 = image3.getBytes();
	   
	}
	
	
	@PostMapping("/addeposit")
	
	public Deposit_of_guarantees addeposit(@RequestBody Deposit_of_guarantees deposit ) {
		
		
		deposit.setEL(img1);
		deposit.setPayslips(img2);
		deposit.setJC(img3);
		 if(vlm.validateEmail(deposit.getAdressMail()))
		 {
	   
		ng.sendSms(new SmsRequest( deposit.getPhoneNumber()));
		 
		
		Deposit_of_guarantees dg = 	service.save(deposit) ;
		
		this.img1 = null ;
		this.img2 = null ;
		this.img3 = null ;
		
		return dg;
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
