package VORTEX.DARIPROJECT.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.Visit;
import VORTEX.DARIPROJECT.service.ServiceVisit;
import VORTEX.DARIPROJECT.service.VisitService;

@RestController
@RequestMapping("visit")
public class visitController {
	
	@Autowired
	private VisitService service;
	@Autowired 
	private ServiceVisit sev ;
	
	
	@PutMapping("/seth")
	public  String setHeureVisit(HttpServletRequest req,HttpServletResponse res) {
		sev.sehllvist(res);
		return "heure update";
	}
	
	@GetMapping("/expire")
	public Cookie[] expireVisit(HttpServletRequest req,HttpServletResponse res)
	{
		 return req.getCookies();
	}
	@PostMapping("/addVisit")
	public Visit addVisit(@RequestBody Visit visits) {
		return service.saveVisits(visits);
	}
	
	@GetMapping("/visit")
	public List<Visit> findVisit() {
		return service.getVisitsById();
	}
	
	@PutMapping("/update")
	public Visit updateVisit(@RequestBody Visit visit) {
		return service.updateVisit(visit);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteVisit(@PathVariable int id) {
		return service.deleteVisit(id);
	}

}
