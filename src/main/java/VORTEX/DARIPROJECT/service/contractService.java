package VORTEX.DARIPROJECT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Contract;
import VORTEX.DARIPROJECT.Repository.contractRepository;

@Service
public class contractService {
	
	@Autowired
	private contractRepository repository;
	
	public Contract saveContract(Contract contract) {
		return repository.save(contract);
	}
	
	public Contract getContractsById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteContract(int id) {
		repository.deleteById(id);
		return "Contract removed!!"+id;
	}
	
	public Contract updateContract(Contract contract) {
		Contract existingContract=repository.findById(contract.getContractnum()).orElse(null);
		existingContract.setEffective_price(contract.getEffective_price());
		existingContract.setEffective_Date(contract.getEffective_Date());
		return repository.save(existingContract);
	}

	
}
