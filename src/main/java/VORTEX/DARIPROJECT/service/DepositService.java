package VORTEX.DARIPROJECT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Deposit_of_guarantees;

import VORTEX.DARIPROJECT.Repository.DepositRepo;

@org.springframework.stereotype.Service
//@Service

public class DepositService {
 
	@Autowired
    public DepositRepo dg;
	private  SmsSender smsSender;
	
	public Deposit_of_guarantees save(Deposit_of_guarantees Deposit_of_guarantees) {
		return dg.save(Deposit_of_guarantees);
	}
	
	public Deposit_of_guarantees getdepositById(long id) {
		return dg.findById(id).orElse(null);
	}
	
	public String deletedeposit(long id) {
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
	public void Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
	        this.smsSender = smsSender;
	}

	    public void sendSms(SmsRequest smsRequest) {
	        smsSender.sendSms(smsRequest);
	    }
//	public List<real_estate> retreiveallRealEstates(int id){
//		return rep.findAll(id).orElse(null);}

}

