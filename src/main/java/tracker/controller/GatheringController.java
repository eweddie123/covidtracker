package tracker.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tracker.dao.GatheringRepository;
import tracker.domain.Gathering;

@Controller // This means that this class is a Controller
@RequestMapping(path="/gathering") // This means URL's start with gathering (after Application path)
public class GatheringController {
	@Autowired
	private GatheringRepository gatheringRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewGathering (@RequestBody Gathering gathering) {
		gatheringRepository.save(gathering);
		return "Saved";
	}
	
	@DeleteMapping(path="/delete/{id}") // Map ONLY DELETE Requests
	public @ResponseBody String deleteGathering (@PathVariable("id") int id) {
		gatheringRepository.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping(path="/{id}") // Map ONLY GET Requests
	public @ResponseBody Optional<Gathering> getGathering (@PathVariable("id") int id) {
		return gatheringRepository.findById(id);
	}
	
	/*@GetMapping(path="/find") // Map ONLY GET Requests
	public @ResponseBody Iterable<Optional<Gathering>> getGatheringListByDate (@RequestParam Date date) {
		return gatheringRepository.findByDate(date);
	}*/
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Gathering> getAllGatherings() {
		// This returns a JSON or XML with the users
		return gatheringRepository.findAll();
	}
	
	@PutMapping(path="/edit/{id}")
	public @ResponseBody String editGathering(@PathVariable("id") int id, @RequestBody Gathering editGathering) {
		gatheringRepository.findById(id)
		.map(gathering -> {
			gathering.setOrganizerId(editGathering.getOrganizerId());
			gathering.setGatheringName(editGathering.getGatheringName());
			gathering.setDateTime(editGathering.getDateTime());
			gathering.setLocation(editGathering.getLocation());
			return gatheringRepository.save(gathering);
		});
		
		return "Edited";
	}
}
