package VORTEX.DARIPROJECT.SERVICE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Annonce;
import VORTEX.DARIPROJECT.ENTITY.User;
import VORTEX.DARIPROJECT.REPOSITORY.AnnoceRepo;

import java.util.List;

@Service
public class AnnoceService implements IAnnonceService {


    @Autowired
    AnnoceRepo annonceRepo ;
    private static final Logger l = LogManager.getLogger(AnnoceService.class);

    @Override
    public List<Annonce> retrieveAllAnnonce() {

        List<Annonce> annonces = (List<Annonce>) annonceRepo.findAll();
        for(Annonce ac : annonces)
        {
            l.info("annonce +++ : "+ac);
        }
        return annonces;
    }

    @Override
    public Annonce addAnnonce(Annonce r) {

        l.info("Adding Annonce with ID: "+r.getId());
        return annonceRepo.save(r);
    }

    @Override
    public void deleteAnnonce   (String id) {
        l.info("Deleting Annonce with ID: "+id);
        annonceRepo.deleteById(Integer.parseInt(id));

    }

    @Override
    public Annonce updateAnnonce(Annonce r) {
        l.info("Updating Annonce with ID: "+r.getId());
        return this.annonceRepo.save(r);
    }

    @Override
    public Annonce findAnnonceById(int r) {
        l.info("Retriving Annonce with ID: "+r);
        return this.annonceRepo.findById(r).get();
    }


    @Override
    public List<Annonce> retrieveAdsbyLocationAndUser(String l, User user) {
        // TODO Auto-generated method stub
        return this.annonceRepo.Search(l,user);
    }

    @Override
    public Annonce saveImage(Annonce ad) {
        // TODO Auto-generated method stub
        return annonceRepo.save(ad);
    }



}
