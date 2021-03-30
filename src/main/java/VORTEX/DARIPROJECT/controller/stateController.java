package VORTEX.DARIPROJECT.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import VORTEX.DARIPROJECT.ENTITY.real_estate;
import VORTEX.DARIPROJECT.service.stateService;

@RestController
@RequestMapping("state")
@CrossOrigin("*")
public class stateController {
	
	@Autowired
	private stateService service;
	
	@PostMapping("/addstate")
	public real_estate addstate(@RequestBody real_estate state) {
		return service.save(state);
	}
	
	@GetMapping("/state/{id}")
	public real_estate findById(@PathVariable int id) {
		return service.getRealstateById(id);
	}
	
	@PutMapping("/update")
	public real_estate updatereal_estate(@RequestBody real_estate state) {
		return service.updatereal_estate(state);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteRealstate(@PathVariable int id) {
		return service.deleteRealstate(id);
	}
	

}
