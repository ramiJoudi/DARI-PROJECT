package VORTEX.DARIPROJECT.REPOSITORY;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Claim;
@Repository
public interface REPOSITORY_Claim extends CrudRepository<Claim, Integer>{

}
