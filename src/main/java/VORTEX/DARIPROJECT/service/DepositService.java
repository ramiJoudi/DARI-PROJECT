package VORTEX.DARIPROJECT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Deposit_of_guarantees;

import VORTEX.DARIPROJECT.Repository.DepositRepo;


@Service
public class DepositService {

	@Autowired
    public DepositRepo dg;
	
	public Deposit_of_guarantees save(Deposit_of_guarantees Deposit_of_guarantees) {
		return dg.save(Deposit_of_guarantees);
	}
	
	public Deposit_of_guarantees getdepositById(int id) {
		return dg.findById(id).orElse(null);
	}
	
	public String deletedeposit(int id) {
		dg.deleteById(id);
		return "Realstate removed!!"+id;
	}
	public Deposit_of_guarantees updaterdeposit(Deposit_of_guarantees depo) {
		Deposit_of_guarantees existingdeposit=dg.findById(depo.getID()).orElse(null);
		existingdeposit.setJC(depo.getJC());
		existingdeposit.setPayslips(depo.getPayslips());
		existingdeposit.setEL(depo.getEL());
		return dg.save(depo);
	}
//	public List<real_estate> retreiveallRealEstates(int id){
//		return rep.findAll(id).orElse(null);}

}

