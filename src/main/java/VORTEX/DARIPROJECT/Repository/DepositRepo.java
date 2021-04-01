package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import VORTEX.DARIPROJECT.ENTITY.Deposit_of_guarantees;

@Repository
public interface DepositRepo extends JpaRepository<Deposit_of_guarantees,Integer> {
 
}
