package VORTEX.DARIPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VORTEX.DARIPROJECT.ENTITY.Visit;
import VORTEX.DARIPROJECT.Repository.VisitRepository;

@Service
public class VisitService {
	
	@Autowired
	
	private final VisitRepository repository;
	
	
	VisitService( VisitRepository repository){
	this.repository=repository;	
	}
	
	public Visit saveVisits(Visit visits) {
		return repository.save(visits);
	}
	
	public List<Visit> getVisitsById() {
		return repository.findAll();
	}
 
	public String deleteVisit(int id) {
		repository.deleteById(id);
		return "visit removed!!"+id;
	}
	
	public Visit updateVisit(Visit visit) {
		Visit existingVisit=repository.findById(visit.getId()).orElse(null);
		existingVisit.setResponsable(visit.getResponsable());
		return repository.save(existingVisit);
	}
}
