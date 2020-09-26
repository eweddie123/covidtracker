package tracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tracker.domain.User;
import tracker.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	@Autowired 
	private UserService userService;
	
	@PostMapping(path="/add")
	public String addNewUser (@RequestBody User user) {
	  userService.save(user);
	  return "Saved";
	}
	
	@PostMapping(path = "/go/{userId}/{gatheringId}")
	public String goToGathering(@PathVariable("userId") int userId, @PathVariable("gatheringId") int gatheringId) {
		System.out.println("goToGathering(): userId = " + userId);
		System.out.println("goToGathering(): gatheringId = " + gatheringId);
		userService.goToGathering(userId, gatheringId);
		return "Done";
	}
	
	@PutMapping(path="/edit/{id}")
	public String editUser(@PathVariable("id") int id, @RequestBody User editUser) {
		userService.putById(id, editUser);
		return "Edited";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteUser (@PathVariable("id") int id) {
		userService.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping(path="/{id}")
	public Optional<User> getUser (@PathVariable("id") int id) {
		System.out.println("getUserStatus id = " + id);
	    return userService.findById(id);
	}
	
	@GetMapping(path="/find")
	public Iterable<Optional<User>> getUserByLastName (@RequestParam (name = "lastName", required = false, defaultValue = "Wang") String lastName) {
		System.out.println("getUserByLastName(): lastName=" + lastName);
	    return userService.findByLastName(lastName);
	}
	
	@GetMapping(path="/users")
	public Iterable<User> getAllUsers() {
		return userService.findAll();
	}
}
