package VORTEX.DARIPROJECT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import VORTEX.DARIPROJECT.ENTITY.real_estate;

@Repository
public interface stateRepository extends JpaRepository<real_estate,Long> {
	@Query("SELECT m FROM real_estate m WHERE m.location LIKE CONCAT('%',:location,'%') and (m.buy=1 or m.rent=1)")
	public List<real_estate> searchstate(@Param("location") String location);

}
