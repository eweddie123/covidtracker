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

import tracker.dao.UserRepository;
import tracker.domain.User;

@Controller
@RequestMapping(path="/user")
public class UserController {
	@Autowired // This means to get the bean called userRepository
	private UserRepository userRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestBody User user) {
	  userRepository.save(user);
	  return "Saved";
	}
	
	@PutMapping(path="/edit/{id}")
	public @ResponseBody String editUser(@PathVariable("id") int id, @RequestBody User editUser) {
		userRepository.findById(id)
		.map(user -> {
			user.setFirstName(editUser.getFirstName());
			user.setLastName(editUser.getLastName());
			user.setEmail(editUser.getEmail());
			user.setScore(editUser.getScore());
			user.setPicture(editUser.getPicture());
			return userRepository.save(user);
		});
		
		return "Edited";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteUser (@PathVariable("id") int id) {
		userRepository.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<User> getUser (@PathVariable("id") int id) {
		System.out.println("getUserStatus id = " + id);
	    return userRepository.findById(id);
	}
	
	@GetMapping(path="/find")
	public @ResponseBody Iterable<Optional<User>> getUserByLastName (@RequestParam (required = true) String lastName) {
	    return userRepository.findByLastName(lastName);
	}
	
	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
