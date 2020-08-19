package tracker.controller;

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

import tracker.dao.UserGatheringRepository;
import tracker.domain.UserGathering;

@Controller
@RequestMapping(path="/ug")
public class UserGatheringController {
	@Autowired
	private UserGatheringRepository userGatheringRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUserGathering (@RequestBody UserGathering userGathering) {
		userGatheringRepository.save(userGathering);
		return "Saved";
	}
	
	@DeleteMapping(path="/delete/{id}") // Map ONLY DELETE Requests
	public @ResponseBody String deleteUserGathering (@PathVariable("id") int id) {
		userGatheringRepository.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping(path="/{id}") // Map ONLY GET Requests
	public @ResponseBody Optional<UserGathering> getUserGathering (@PathVariable("id") int id) {
		return userGatheringRepository.findById(id);
	}
	
	@GetMapping(path="/find/{userId}") // Map ONLY GET Requests
	public @ResponseBody Iterable<Optional<UserGathering>> getUserGatheringListByUserId (@PathVariable("userId") int userId) {
		return userGatheringRepository.findByUserId(userId);
	}
	
	@GetMapping(path="/find/{gatheringId}") // Map ONLY GET Requests
	public @ResponseBody Iterable<Optional<UserGathering>> getUserGatheringListByGatheringId 
	(@PathVariable("gatheringId") Integer gatheringId) {
		return userGatheringRepository.findByGatheringId(gatheringId);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<UserGathering> getAllUserGatherings() {
		// This returns a JSON or XML with the users
		return userGatheringRepository.findAll();
	}
}
