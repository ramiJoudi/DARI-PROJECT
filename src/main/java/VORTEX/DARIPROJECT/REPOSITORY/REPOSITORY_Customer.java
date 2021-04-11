package VORTEX.DARIPROJECT.REPOSITORY;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.ENTITY.customer;

@Repository
public interface REPOSITORY_Customer extends CrudRepository<customer, Integer> {
	customer findByEmail(String email);
	customer findByVerificationCode(String verificationCode);
	customer findByUsername(String username);
}
