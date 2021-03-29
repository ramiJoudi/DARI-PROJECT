package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import VORTEX.DARIPROJECT.ENTITY.real_estate;

@Repository
public interface stateRepository extends JpaRepository<real_estate,Integer> {

}