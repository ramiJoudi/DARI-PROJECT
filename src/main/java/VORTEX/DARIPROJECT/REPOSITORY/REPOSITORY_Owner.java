package VORTEX.DARIPROJECT.REPOSITORY;

 


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.owner;
 
@Repository
public interface REPOSITORY_Owner extends CrudRepository<owner, Integer>{
	owner findByEmail(String email);
	owner findByVerificationCode(String verificationCode);
}
