package VORTEX.DARIPROJECT.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Ads;


@Repository
public interface AnnoceRepo extends CrudRepository<Ads,Integer> {

}
