package tracker.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tracker.domain.Gathering;
import tracker.service.GatheringService;

@RestController
@RequestMapping(path="/gathering")
public class GatheringController {
	
	@Autowired
	private GatheringService gatheringService;
	
	@PostMapping(path="/add")
	public String addNewGathering (@RequestBody Gathering gathering) {
		gatheringService.save(gathering);
		return "Saved";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteGathering (@PathVariable("id") int id) {
		gatheringService.deleteById(id);
		return "Deleted";
	}
	
	@PutMapping(path="/edit/{id}")
	public String editGathering(@PathVariable("id") int id, @RequestBody Gathering editGathering) {
		gatheringService.putById(id, editGathering);
		return "Edited";
	}
	
	@GetMapping(path="/{id}")
	public Optional<Gathering> getGathering (@PathVariable(name = "id", required = true) int id, HttpServletRequest httpRequest) {
		System.out.println("getGathering(): id = " + id);
		System.out.println("getGathering(): httpServletRequestURI = " + httpRequest.getRequestURI());
		System.out.println("getGathering(): httpServletRequestURL = " + httpRequest.getRequestURL());
		return gatheringService.findById(id);
	}
	
	@GetMapping(path="/gatherings")
	public Iterable<Gathering> getAllGatherings() {
		return gatheringService.findAll();
	}

}
