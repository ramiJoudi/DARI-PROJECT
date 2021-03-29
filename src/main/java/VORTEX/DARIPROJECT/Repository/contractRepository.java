package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Contract;
@Repository
public interface contractRepository extends JpaRepository<Contract,Integer>{

}
