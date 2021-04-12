package VORTEX.DARIPROJECT.REPOSITORY;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Claim;

import VORTEX.DARIPROJECT.ENTITY.ClaimType;
@Repository
public interface REPOSITORY_Claim extends CrudRepository<Claim, Integer>{
	List<Claim> getByClaimSubject(ClaimType claimSubject);

}
