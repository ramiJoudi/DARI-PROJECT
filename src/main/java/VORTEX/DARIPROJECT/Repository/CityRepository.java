package VORTEX.DARIPROJECT.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
