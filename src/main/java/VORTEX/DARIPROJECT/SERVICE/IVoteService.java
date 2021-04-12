package VORTEX.DARIPROJECT.SERVICE;

import org.springframework.stereotype.Service;


import java.util.List;

 @Service
 public interface IVoteService {

    List<VORTEX.DARIPROJECT.ENTITY.Vote> retrieveAllVote();
    VORTEX.DARIPROJECT.ENTITY.Vote findVoteById(int r);
    VORTEX.DARIPROJECT.ENTITY.Vote findLikeByAnnonceAndUser(VORTEX.DARIPROJECT.ENTITY.Annonce r, VORTEX.DARIPROJECT.ENTITY.User user);
    VORTEX.DARIPROJECT.ENTITY.Vote addVoteLike(int idp , int idu);
    VORTEX.DARIPROJECT.ENTITY.Vote addVoteDeslike(int idp , int idu);
    int NbrLike(VORTEX.DARIPROJECT.ENTITY.Annonce a);
    void deleteVote(String id);
    VORTEX.DARIPROJECT.ENTITY.Annonce MaxAnnonceLike();

 }
