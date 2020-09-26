package tracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tracker.domain.Gathering;
import tracker.domain.User;
import tracker.domain.UserGathering;
import tracker.repository.GatheringRepository;
import tracker.repository.UserGatheringRepository;
import tracker.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GatheringRepository gatheringRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
	
	public void putById(Integer id, User editUser) {
		findById(id)
		.map(user -> {
			user.setFirstName(editUser.getFirstName());
			user.setLastName(editUser.getLastName());
			user.setEmail(editUser.getEmail());
			user.setScore(editUser.getScore());
			user.setPicture(editUser.getPicture());
			return userRepository.save(user);
		});
	}
	
	public Optional<User> findById(Integer id) {
		System.out.print("findById(): id = " + id);
		return userRepository.findById(id);
	}
	
	public Iterable<Optional<User>> findByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	public void goToGathering(Integer userId, Integer gatheringId) {
		User user = userRepository.findById(userId).get();
		Gathering gathering = gatheringRepository.findById(gatheringId).get();
		user.addGathering(gathering);
		userRepository.save(user);
	}
}
