package VORTEX.DARIPROJECT.SERVICE;



import java.util.List;

public interface IAnnonceService {


    List<VORTEX.DARIPROJECT.ENTITY.Annonce> retrieveAllAnnonce();
    VORTEX.DARIPROJECT.ENTITY.Annonce addAnnonce(VORTEX.DARIPROJECT.ENTITY.Annonce r);
    void deleteAnnonce(String id);
    VORTEX.DARIPROJECT.ENTITY.Annonce updateAnnonce(VORTEX.DARIPROJECT.ENTITY.Annonce r);
    VORTEX.DARIPROJECT.ENTITY.Annonce findAnnonceById(int r);
    List<VORTEX.DARIPROJECT.ENTITY.Annonce> retrieveAdsbyLocationAndUser(String l , VORTEX.DARIPROJECT.ENTITY.User user);
    public VORTEX.DARIPROJECT.ENTITY.Annonce saveImage(VORTEX.DARIPROJECT.ENTITY.Annonce a);

}
