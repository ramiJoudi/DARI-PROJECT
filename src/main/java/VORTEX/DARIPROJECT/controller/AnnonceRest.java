package VORTEX.DARIPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Ads;
import VORTEX.DARIPROJECT.service.IAnnonceService;

@RestController
public class AnnonceRest {

    @Autowired
    IAnnonceService annonceService ;

    //http://localhost:8081/SpringMVC/servlet/AllAnnonce
    @GetMapping("/AllAnnonce")
    @ResponseBody
    public List<Ads> getAnnonces() {
        List<Ads> list = annonceService.retrieveAllAnnonce();
        return list;
    }


    @PostMapping("/add-Annonce")
    @ResponseBody
    public Ads addActivity(@RequestBody Ads a) {
        Ads annonce = annonceService.addAnnonce(a);
        return annonce ; }

    @PutMapping("/modify-Annonce")
    @ResponseBody
    public Ads modifyAnnonce(@RequestBody Ads rec) {
        return annonceService.updateAnnonce(rec);  }

    @DeleteMapping("/remove-Annonce/{annonce-id}")
    @ResponseBody
    public void removeActivity(@PathVariable("annonce-id") String AnnonceId) {
        annonceService.deleteAnnonce(AnnonceId);
    }


    @GetMapping("/retrieve-annonce/{annonce-id}")
    @ResponseBody
    public Ads retrieveActivity(@PathVariable("annonce-id") int annonceId) {
        return annonceService.findAnnonceById(annonceId);  }

}
