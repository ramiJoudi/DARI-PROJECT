package VORTEX.DARIPROJECT.service;

import java.util.List;

import VORTEX.DARIPROJECT.ENTITY.Ads;

public interface IAnnonceService {


    List<Ads> retrieveAllAnnonce();
    Ads addAnnonce(Ads  r);
    void deleteAnnonce(String id);
    Ads  updateAnnonce(Ads  r);
    Ads  findAnnonceById(int r);
}
