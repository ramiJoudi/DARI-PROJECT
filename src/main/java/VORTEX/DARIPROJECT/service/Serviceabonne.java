package VORTEX.DARIPROJECT.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import VORTEX.DARIPROJECT.ENTITY.subscription;
import VORTEX.DARIPROJECT.Repository.SubscriptionRepository;
@Service
public class Serviceabonne {
	@Autowired
	private SubscriptionRepository  subrep; 
	

	@Scheduled(cron="0 0/2 * 1/1 * ?")
	
	public List<subscription> gtSubr() {
		
		List<subscription>  lk = new ArrayList<>();
		
		for(subscription s : subrep.findAll()) {
			if(s.isSub() == true) {
				lk.add(s);
			}
		}
		//return null;{7
		
		for(subscription s1 :lk) {
			System.out.println(s1.getOffer());
		}
		return lk;
		
		
	}
}
