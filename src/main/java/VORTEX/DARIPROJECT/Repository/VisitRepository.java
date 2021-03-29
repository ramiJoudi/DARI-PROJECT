package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Visit;
@Repository
public interface VisitRepository extends JpaRepository<Visit,Integer>{

	
}
