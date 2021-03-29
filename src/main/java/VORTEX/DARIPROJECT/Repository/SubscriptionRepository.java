package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<subscription,Integer>{

}
