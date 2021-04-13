package VORTEX.DARIPROJECT.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Bank;
import VORTEX.DARIPROJECT.REPOSITORY.BankRepository;
import VORTEX.DARIPROJECT.SERVICE.BankService;

@RestController
@RequestMapping("customerHome/bank")
public class BankController {
	
	@Autowired
	private BankService service; 
	
	@GetMapping("/addbank")
	public Bank addBank(@RequestBody Bank Bank) {
		return service.saveBank(Bank);
	}
	
	@GetMapping("/find/{id}")
	public Bank findBankById(@PathVariable int id) {
		return service.getBanksById(id);
	}
	@GetMapping("/all")
	public List<Bank> findBanks() {
		return service.getBanks();
	}
	@GetMapping("/findbank/{bankName}")
	//public List<Bank> findBanksbyName(@RequestBody String bankName) {
	public List<Bank> findBanksbyName(@PathVariable String bankName) {
		return service.findBankNameList(bankName);}
	@GetMapping("/update")
	public Bank updateBank(@RequestBody Bank Bank) {
		return service.updateBank(Bank);
	}

	@GetMapping("/delete/{id}")
	public String deleteBank(@PathVariable int id) {
		return service.deleteBank(id);
	}
	

}
