package VORTEX.DARIPROJECT.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Bank;
import VORTEX.DARIPROJECT.REPOSITORY.BankRepository;

@Service
public class BankService {
	
	@Autowired
	private BankRepository repository;

	public Bank saveBank(Bank Bank) {
		return repository.save(Bank);
	}
	
	public Bank getBanksById(int id) {
		return repository.findById(id).orElse(null);
	}
	public List<Bank> getBanks() {
		return repository.findAll();
	}	
	public String deleteBank(int id) {
		repository.deleteById(id);
		return "Bank deleted "+id;
	}
	public Bank updateBank(Bank Bank) {
		Bank existingBank=repository.findById(Bank.getBankId()).orElse(null);
		existingBank.setBankName(Bank.getBankName());
		existingBank.setInterestRate(Bank.getInterestRate());
		return repository.save(existingBank);
	}
	public boolean findBankNameT(String bankName) //test whether the Bank list is empty
	{
		return repository.findByBanknameL(bankName).isEmpty();
		
		
	}
	public List<Bank> findBankNameList(String bankName) // searches by name and returns a list of banks
	{
		return repository.findByBanknameL(bankName);
	}
	public float findInterestRateByName(String BankName)
	{
		return repository.findByBanknameIr(BankName);
	}
	public Bank findBank(String bankName) {
	return repository.findByBankname(bankName.toUpperCase());
	}
	
}
