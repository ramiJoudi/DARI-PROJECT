package VORTEX.DARIPROJECT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.subscription;
import VORTEX.DARIPROJECT.Repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
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
	
	

}
