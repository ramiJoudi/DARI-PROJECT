package VORTEX.DARIPROJECT.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Ads;
import VORTEX.DARIPROJECT.Repository.AnnoceRepo;

@Service
public class AnnoceService implements IAnnonceService {


    @Autowired
    AnnoceRepo annonceRepo ;
    private static final Logger l = LogManager.getLogger(AnnoceService.class);

   @Override
    public List<Ads> retrieveAllAnnonce() {

        List<Ads> annonces = (List<Ads>) annonceRepo.findAll();
        for(Ads ac : annonces)
        {
            l.info("annonce +++ : "+ac);
        }
        return annonces;
    }

    public Ads addAnnonce(Ads r) {

        l.info("Adding Annonce with ID: "+r.getAdID());
        return annonceRepo.save(r);
    }

    @Override
    public void deleteAnnonce   (String id) {
        l.info("Deleting Annonce with ID: "+id);
        annonceRepo.deleteById(Integer.parseInt(id));

    }

    @Override
    public Ads updateAnnonce(Ads r) {
        l.info("Updating Annonce with ID: "+r.getAdID());
        return this.annonceRepo.save(r);
    }

    @Override
    public Ads findAnnonceById(int r) {
        l.info("Retriving Annonce with ID: "+r);
        return this.annonceRepo.findById(r).get();
    }

}
