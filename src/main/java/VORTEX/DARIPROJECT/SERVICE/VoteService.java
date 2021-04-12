package VORTEX.DARIPROJECT.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Annonce;
import VORTEX.DARIPROJECT.ENTITY.User;
import VORTEX.DARIPROJECT.ENTITY.Vote;

import java.util.List;

@Service
public class VoteService implements IVoteService {


    @Autowired
    VORTEX.DARIPROJECT.REPOSITORY.VoteRepository VoteRepo ;
    @Autowired
    SERVICE_USER userService;
    @Autowired
    IAnnonceService annonceService;


    @Override
    public List<Vote> retrieveAllVote() {
        List<Vote> votes = (List<Vote>) VoteRepo.findAll();
        return votes;
    }

    @Override
    public Vote findVoteById(int r) {
        return this.VoteRepo.findById(r).get();
    }

    @Override
    public Vote findLikeByAnnonceAndUser(Annonce r, User user) {
        return  this.VoteRepo.SearchLike(r,user);
    }

    @Override
    public Vote addVoteLike(int idp, int idu) {
        Vote r = new Vote();
        Vote vote = new Vote();
        vote = findLikeByAnnonceAndUser(annonceService.findAnnonceById(idp),userService.findById(idu));
        r.setUser(userService.findById(idu));
        r.setAnnonce(annonceService.findAnnonceById(idp));
        r.setType(1);
        if(vote != null){
            VoteRepo.deleteById(vote.getId());
        }
        return VoteRepo.save(r);

    }

    @Override
    public Vote addVoteDeslike(int idp, int idu) {
        Vote r = new Vote();
        Vote vote = new Vote();
        vote = findLikeByAnnonceAndUser(annonceService.findAnnonceById(idp),userService.findById(idu));
        r.setUser(userService.findById(idu));
        r.setAnnonce(annonceService.findAnnonceById(idp));
        r.setType(2);
        if(vote != null){
            VoteRepo.deleteById(vote.getId());
        }
        return VoteRepo.save(r);

    }

    @Override
    public int NbrLike(Annonce a) {
        return VoteRepo.NbrlikeAnnonce(a);
    }

    @Override
    public void deleteVote(String id) {

        VoteRepo.deleteById(Integer.parseInt(id));

    }


    @Override
    public Annonce MaxAnnonceLike(){

        int max = 0 ;
        Annonce a = new Annonce();

        for(Annonce c :annonceService.retrieveAllAnnonce()){
            int x =VoteRepo.NbrlikeAnnonce(c);

            if(x>max){
                max=x;
                a=c;
            }

        }

        return a;

    }
}
