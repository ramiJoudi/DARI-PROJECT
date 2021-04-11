package VORTEX.DARIPROJECT.REPOSITORY;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

 

 
import VORTEX.DARIPROJECT.ENTITY.admin;
@Repository
public interface REPOSITORY_Admin extends CrudRepository<admin, Integer>  {
	admin findByEmail(String email);
	
	admin findByVerificationCode(String verificationCode);
}
