package VORTEX.DARIPROJECT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Contract;
import VORTEX.DARIPROJECT.service.contractService;

@RestController

public class contractController {
	
	@Autowired
	private contractService service; 
	
	@PostMapping("/addcontract")
	public Contract addContract(@RequestBody Contract contract) {
		return service.saveContract(contract);
	}
	
	@GetMapping("/contract/{id}")
	public Contract findContractById(@PathVariable int id) {
		return service.getContractsById(id);
	}
	
	@PutMapping("/update")
	public Contract updateContract(@RequestBody Contract contract) {
		return service.updateContract(contract);
	}
	
	@DeleteMapping("/deletecontract/{id}")
	public String deleteContract(@PathVariable int id) {
		return service.deleteContract(id);
	}

}
