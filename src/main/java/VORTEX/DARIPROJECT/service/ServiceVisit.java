package VORTEX.DARIPROJECT.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Visit;
import VORTEX.DARIPROJECT.Repository.VisitRepository;

@Service 

public class ServiceVisit {
	
	
	@Autowired
	private VisitRepository vistrep ;
	
	 
	@Transactional
	 public void  sehllvist(HttpServletResponse res){
		 
		 List<Visit>  lv = vistrep.findAll();
		 for (Visit v  :  lv ) {
			 if(v.getIsdisp() == false) {
				 /*v.setId(v.getId());
				 v.setN_heure(60.0 * 60.0 * 3.0);
				 vistrep.save(v);*/
				 
				 vistrep.findById(v.getId()).map(nb ->{
					Cookie cokie  = new Cookie("visit"+nb.getId(),"visit"+nb.getResponsable());
					cokie.setMaxAge(60 * 60 * 3);
					//cokie.setSecure(true);
					cokie.setHttpOnly(true);
					cokie.setPath("/");
					res.addCookie(cokie);
					nb.setId(nb.getId());
					 nb.setN_heure(60.0 * 60.0 * 3.0);
					return  vistrep.save(nb);
				 });
				 
			 }
			 else {
				 vistrep.findById(v.getId()).map(nb ->{
						Cookie cokie  = new Cookie("visit"+nb.getId(),"visit"+nb.getResponsable());
						cokie.setMaxAge(60 * 60 * 24);
					//	cokie.setSecure(true);
						cokie.setHttpOnly(true);
						cokie.setPath("/");
						res.addCookie(cokie);
					 nb.setId(nb.getId());
					 nb.setN_heure(60.0 * 60.0 * 24);
					return  vistrep.save(nb);
				 });
				 
			 }
		 }
		 
	 }
	

}
