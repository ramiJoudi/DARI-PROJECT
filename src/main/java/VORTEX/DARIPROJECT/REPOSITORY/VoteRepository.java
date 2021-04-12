package VORTEX.DARIPROJECT.REPOSITORY;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import VORTEX.DARIPROJECT.ENTITY.Annonce;


@Repository
public interface VoteRepository extends CrudRepository<VORTEX.DARIPROJECT.ENTITY.Vote,Integer> {

    @Query("SELECT v FROM Vote v WHERE v.annonce= :annonce AND v.user= :user")
    VORTEX.DARIPROJECT.ENTITY.Vote SearchLike(@Param("annonce") VORTEX.DARIPROJECT.ENTITY.Annonce annonce, @Param("user") VORTEX.DARIPROJECT.ENTITY.User user);

    @Query("SELECT COUNT(u) FROM Vote u WHERE u.type=1")
    int Nbrlike ();

    @Query("SELECT COUNT(u) FROM Vote u WHERE u.type=1"+"AND u.annonce= :annonce")
    int NbrlikeAnnonce (@Param("annonce") Annonce annonce );
}
