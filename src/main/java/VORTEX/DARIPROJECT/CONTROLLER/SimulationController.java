package VORTEX.DARIPROJECT.CONTROLLER;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Loan;
import VORTEX.DARIPROJECT.SERVICE.SimulationService;

@RestController
@RequestMapping("customerHome/loan")
public class SimulationController {
	
	@Autowired
	private SimulationService service; 
	
	@GetMapping("/addloan")
	public Loan addLoan(@RequestBody Loan Loan) {
		return service.saveLoan(Loan);
	}
	
	@GetMapping("/find/{id}")
	public Loan findLoanById(@PathVariable int id) {
		return service.getLoansById(id);
	}
	@GetMapping("/all")
	public List<Loan> findLoans() {
		return service.getLoans();
	}
	@GetMapping("/update")
	public Loan updateLoan(@RequestBody Loan Loan) {
		return service.updateLoan(Loan);
	}

	@GetMapping("/delete/{id}")
	public String deleteLoan(@PathVariable int id) {
		return service.deleteLoan(id);
	}
}