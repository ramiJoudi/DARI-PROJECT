package VORTEX.DARIPROJECT.REPOSITORY;

 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Operator;
import VORTEX.DARIPROJECT.ENTITY.admin;

@Repository
public interface REPOSITORY_Operator extends CrudRepository<Operator, Integer>{
	Operator findByEmail(String email);
	Operator findByVerificationCode(String verificationCode);
}

