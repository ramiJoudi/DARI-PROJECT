package VORTEX.DARIPROJECT.REPOSITORY;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.User;

@Repository
public interface REPOSITORY_User  extends CrudRepository<User, Integer>  {
	 User findByUsername(String username);
	 User findUserById(int id );
}
