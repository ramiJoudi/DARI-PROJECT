package VORTEX.DARIPROJECT.CONTROLLER;


import com.sun.istack.Nullable;

import VORTEX.DARIPROJECT.ENTITY.Annonce;
import VORTEX.DARIPROJECT.ENTITY.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class AnnonceRest {

    @Autowired
    VORTEX.DARIPROJECT.SERVICE.IAnnonceService annonceService ;

    //http://localhost:8081/SpringMVC/servlet/AllAnnonce
    @GetMapping("/AllAnnonce")
    @ResponseBody
    public List<Annonce> getAnnonces() {
        List<Annonce> list = annonceService.retrieveAllAnnonce();
        return list;
    }


    @PostMapping("/add-Annonce")
    @ResponseBody
    public Annonce addActivity(@RequestBody Annonce a) {
        Annonce annonce = annonceService.addAnnonce(a);
        return annonce ; }

    @PutMapping("/modify-Annonce")
    @ResponseBody
    public Annonce modifyAnnonce(@RequestBody Annonce rec) {
        return annonceService.updateAnnonce(rec);  }

    @DeleteMapping("/remove-Annonce/{annonce-id}")
    @ResponseBody
    public void removeActivity(@PathVariable("annonce-id") String AnnonceId) {
        annonceService.deleteAnnonce(AnnonceId);
    }


    @GetMapping("/retrieve-annonce/{annonce-id}")
    @ResponseBody
    public Annonce retrieveActivity(@PathVariable("annonce-id") int annonceId) {
        return annonceService.findAnnonceById(annonceId);  }


    @GetMapping("/search/{location}/{user}")
    @ResponseBody

    public List<Annonce> getAdsbyLocation(@PathVariable("location") String Location,@PathVariable("user") User user)
    {
        List<Annonce> list = annonceService.retrieveAdsbyLocationAndUser(Location,user);
        return list;
    }

    @PostMapping("/file")
    @ResponseBody
    public Annonce  uploddimg (@RequestParam("file") @Nullable MultipartFile file, @RequestParam("annonce") int adId ) {
        Annonce ad =annonceService.findAnnonceById(adId);
        if(file==null) {
            ad.setImage("defaultPic.png");
            annonceService.saveImage(ad);
        }else {
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                String path =  classLoader.getResource(".").getFile();

                File f = new File("C:\\upload\\" +"image" + adId+file.getOriginalFilename());
                file.transferTo(f);
                ad.setImage("image"+adId+file.getOriginalFilename());
                annonceService.saveImage(ad);
            } catch (IllegalStateException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return(ad);
    }

}
