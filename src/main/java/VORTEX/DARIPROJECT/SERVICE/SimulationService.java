package VORTEX.DARIPROJECT.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import VORTEX.DARIPROJECT.ENTITY.Loan;
import VORTEX.DARIPROJECT.REPOSITORY.LoanRepository;
import VORTEX.DARIPROJECT.SERVICE.BankService;

@Service
public class SimulationService {
	
	@Autowired
	private LoanRepository repository;
	@Autowired
	private BankService serv;
	public Loan saveLoan(Loan Loan) {
		float monthlyPayments;
		boolean valid;
		String bankName = Loan.getBankname();
		float interestRate;
		valid = serv.findBankNameT(Loan.getBankname());
		if (valid) {
			
			System.out.println("bank name not found");
			Loan.setLoanEroor("bank name not found");
			return Loan;
		}
		else {
		System.out.println("bank name found");
		interestRate =serv.findInterestRateByName(bankName);
		System.out.println(interestRate);
		Loan.setinterestrate(interestRate);
		monthlyPayments = calcLoan(Loan);
		Loan.setMonthly_payment(monthlyPayments);		
		return	repository.save(Loan);
		}
	}
	
	public Loan getLoansById(int id) {
		return repository.findById(id).orElse(null);
	}
	public List<Loan> getLoans() {
		return repository.findAll();
	}	
	public String deleteLoan(int id) {
		repository.deleteById(id);
		return "Loan deleted"+id;
	}
	public Loan updateLoan(Loan Loan) {
		Loan existingLoan=repository.findById(Loan.getIdCredit()).orElse(null);
		existingLoan.setPrice(Loan.getPrice());
		existingLoan.setBankname(Loan.getBankname());
		existingLoan.setLoan_duration(Loan.getLoan_duration());
		return saveLoan(existingLoan);
	}
	public float calcLoan(Loan loan) {
		float interestRate = loan.getinterestrate();
		float price = loan.getPrice();
		float loanduration = loan.getLoan_duration();
		 interestRate /= 100.0;
		float Monthly_payment;
		Monthly_payment = (float) (price * Math.pow(1 + interestRate / 12, loanduration * 12) * (interestRate / 12) / (Math.pow(1 + interestRate / 12, loanduration * 12) - 1));
		return Monthly_payment;
	}
}