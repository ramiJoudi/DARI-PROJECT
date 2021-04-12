package VORTEX.DARIPROJECT.REPOSITORY;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
    public interface AnnoceRepo extends CrudRepository<VORTEX.DARIPROJECT.ENTITY.Annonce, Integer> {

    @Query("SELECT a FROM Annonce a WHERE a.location= :l AND a.user= :user	" )
    List<VORTEX.DARIPROJECT.ENTITY.Annonce> Search(@Param("l") String Location, @Param("user") VORTEX.DARIPROJECT.ENTITY.User user);

}
