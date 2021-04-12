package VORTEX.DARIPROJECT.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import VORTEX.DARIPROJECT.ENTITY.Loan;
import VORTEX.DARIPROJECT.REPOSITORY.LoanRepository;

@Service
public class SimulationService {
	
	@Autowired
	private LoanRepository repository;

	public Loan saveLoan(Loan Loan) {
		float monthlyPayments;
		monthlyPayments = calcLoan(Loan);
		Loan.setMonthly_payment(monthlyPayments);
		return repository.save(Loan);
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
		existingLoan.setinterestrate(Loan.getinterestrate());
		existingLoan.setLoan_duration(Loan.getLoan_duration());
		return repository.save(existingLoan);
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