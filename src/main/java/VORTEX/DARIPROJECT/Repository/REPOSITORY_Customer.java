package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.customer;

@Repository
public interface REPOSITORY_Customer extends CrudRepository<customer, Integer> {

}