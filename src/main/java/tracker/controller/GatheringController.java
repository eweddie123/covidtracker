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

@Controller
@RequestMapping(path="/gathering")
public class GatheringController {
	@Autowired
	private GatheringRepository gatheringRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewGathering (@RequestBody Gathering gathering) {
		gatheringRepository.save(gathering);
		return "Saved";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteGathering (@PathVariable("id") int id) {
		gatheringRepository.deleteById(id);
		return "Deleted";
	}
	
	@PutMapping(path="/edit/{id}")
	public @ResponseBody String editGathering(@PathVariable("id") int id, @RequestBody Gathering editGathering) {
		gatheringRepository.findById(id)
		.map(gathering -> {
			gathering.setGatheringName(editGathering.getGatheringName());
			gathering.setDateTime(editGathering.getDateTime());
			gathering.setLocation(editGathering.getLocation());
			gathering.setDescription(editGathering.getDescription());
			return gatheringRepository.save(gathering);
		});
		
		return "Edited";
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Gathering> getGathering (@PathVariable("id") int id) {
		return gatheringRepository.findById(id);
	}
	
	@GetMapping(path="/gatherings")
	public @ResponseBody Iterable<Gathering> getAllGatherings() {
		return gatheringRepository.findAll();
	}

}
