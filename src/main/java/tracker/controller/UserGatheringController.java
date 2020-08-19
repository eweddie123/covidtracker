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
import tracker.domain.Gathering;
import tracker.domain.UserGathering;

@Controller
@RequestMapping(path="/usergathering")
public class UserGatheringController {
	@Autowired
	private UserGatheringRepository userGatheringRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUserGathering (@RequestBody UserGathering userGathering) {
		userGatheringRepository.save(userGathering);
		return "Saved";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteUserGathering (@PathVariable("id") int id) {
		userGatheringRepository.deleteById(id);
		return "Deleted";
	}
	
	@PutMapping(path="/edit/{id}")
	public @ResponseBody String editUserGathering(@PathVariable("id") int id, @RequestBody UserGathering editUserGathering) {
		userGatheringRepository.findById(id)
		.map(userGathering -> {
			userGathering.setMask(editUserGathering.getMask());
			return userGatheringRepository.save(userGathering);
		});
		
		return "Edited";
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<UserGathering> getUserGathering (@PathVariable("id") int id) {
		return userGatheringRepository.findById(id);
	}
	
	@GetMapping(path="/find/{userId}")
	public @ResponseBody Iterable<Optional<UserGathering>> getUserGatheringListByUserId (@PathVariable("userId") int userId) {
		return userGatheringRepository.findByUserId(userId);
	}
	
	@GetMapping(path="/find/{gatheringId}")
	public @ResponseBody Iterable<Optional<UserGathering>> getUserGatheringListByGatheringId 
	(@PathVariable("gatheringId") Integer gatheringId) {
		return userGatheringRepository.findByGatheringId(gatheringId);
	}
	
	@GetMapping(path="/usergatherings")
	public @ResponseBody Iterable<UserGathering> getAllUserGatherings() {
		// This returns a JSON or XML with the users
		return userGatheringRepository.findAll();
	}

}
