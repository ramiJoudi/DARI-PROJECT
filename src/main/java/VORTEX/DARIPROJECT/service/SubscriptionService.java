package VORTEX.DARIPROJECT.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.subscription;
import VORTEX.DARIPROJECT.Repository.SubscriptionRepository;
import VORTEX.DARIPROJECT.ENTITY.EntityPrice;

@Service
public class SubscriptionService {
	
	@Autowired
	
	private SubscriptionRepository repository;
	
	public List<subscription> saveSubscriptions(List<subscription> Subscriptions) {
		return repository.saveAll(Subscriptions);
	}
	public subscription getSubscriptionsById(int id) {
		return repository.findById(id).orElse(null);
	}
	public String deleteSubscription(int id) {
		repository.deleteById(id);
		return "subscription removed!!"+id;
	}
	public subscription updateSubscription(subscription Subscription) {
		subscription existingSubscription=repository.findById(Subscription.getIdSub()).orElse(null);
		existingSubscription.setOffer(Subscription.getOffer());
		existingSubscription.setSub(Subscription.isSub());
		return repository.save(existingSubscription);
	}
	
	public List<subscription>  getSubprice() {
		
		
		List<subscription> s = repository.findAll();
		List<EntityPrice>   pr  = new ArrayList<EntityPrice>();
		//Map pr2 = new HashMap<String , Long>();
		Long  m1 = new Long((long)120);
		Long  m2 = new Long((long)150);
		for(subscription s1 : s) {
			
			if(s1.isSub())
			{
				
				
				subscription s2  = repository.findById(s1.getIdSub()).get();
				
				System.out.println(s1.getOffer());
				//EntityPrice m = new EntityPrice() ;
				//m.setPrice( 147);
				//m.setS(s1);
				
				s2.setPrice(m1);
				
				
				repository.save(s2);
				
				
			//	pr2.put(s1.getOffer(), m.getPrice());
				
				
				
				
			}
			else {
subscription s2  = repository.findById(s1.getIdSub()).get();
				
				System.out.println(s1.getOffer());
				//EntityPrice m = new EntityPrice() ;
				//m.setPrice( 147);
				//m.setS(s1);
				
				s2.setPrice( m2);
				
				
				repository.save(s2);
			//	pr2.put(s1.getOffer(), m.getPrice());
				
			}
		}
		
	
		
		
		return s;
	}
	
	

}
