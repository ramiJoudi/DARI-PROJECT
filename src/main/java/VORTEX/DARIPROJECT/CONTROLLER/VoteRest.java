package VORTEX.DARIPROJECT.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import VORTEX.DARIPROJECT.SERVICE.SERVICE_USER;


import java.util.List;

@RestController
public class VoteRest {

    @Autowired
    VORTEX.DARIPROJECT.SERVICE.IVoteService voteService ;
    @Autowired
    VORTEX.DARIPROJECT.SERVICE.IAnnonceService annonceService;
    @Autowired
    SERVICE_USER userService ;


    @GetMapping("/retrieve-all-Vote")
    @ResponseBody
    public List<VORTEX.DARIPROJECT.ENTITY.Vote> getComment() {
        List<VORTEX.DARIPROJECT.ENTITY.Vote> list = voteService.retrieveAllVote();
        return list;
    }

    @GetMapping("/retrieve-vote/{vote-id}")
    @ResponseBody
    public VORTEX.DARIPROJECT.ENTITY.Vote retrieveVote(@PathVariable("vote-id") int voteId) {

        return voteService.findVoteById(voteId);
    }


    @GetMapping("/retrieve-voteByUserandPost/{vote-id}/{voteuser}")
    @ResponseBody
    public VORTEX.DARIPROJECT.ENTITY.Vote retrieveVoteByPostandUser(@PathVariable("vote-id") int voteId, @PathVariable("voteuser") int voteuser) {
        return voteService.findLikeByAnnonceAndUser(annonceService.findAnnonceById(voteId), userService.findById(voteuser));
    }



    @PostMapping("/add-votelike/{idp}/{idu}")
    @ResponseBody
    public VORTEX.DARIPROJECT.ENTITY.Vote addVoteLike(@PathVariable("idp") int idp,@PathVariable("idu") int idu) {
        VORTEX.DARIPROJECT.ENTITY.Vote vote = voteService.addVoteLike(idp,idu);
        return vote ;
    }
    @PostMapping("/add-voteDeslike/{idp}/{idu}")
    @ResponseBody
    public VORTEX.DARIPROJECT.ENTITY.Vote addVoteDeslike(@PathVariable("idp") int idp,@PathVariable("idu") int idu) {
        VORTEX.DARIPROJECT.ENTITY.Vote vote = voteService.addVoteDeslike(idp,idu);
        return vote ;
    }

    @DeleteMapping("/remove-vote/{vote-id}")
    @ResponseBody
    public void removeComment(@PathVariable("vote-id") String voteId) {
        voteService.deleteVote(voteId);
    }

    @GetMapping("/MaxNbrLike")
    @ResponseBody
    public VORTEX.DARIPROJECT.ENTITY.Annonce MaxnbrLike() {
        return voteService.MaxAnnonceLike();
    }

    @GetMapping("/MaxNbrLike/{a}")
    @ResponseBody
    public int max(@PathVariable ("a") VORTEX.DARIPROJECT.ENTITY.Annonce a) {
        return voteService.NbrLike(a);
    }
}




