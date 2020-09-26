package tracker.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tracker.domain.User;
import tracker.repository.UserRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void findByIdTest() {
		int id = 20;
		User user = createUser();
		Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
		Optional<User> foundUser = userService.findById(id);
		assertEquals(foundUser.get().getFirstName(), user.getFirstName());
	}
	
	@Test
	public void putByIdTest() {
		int id = 20;
		User user = createUser();
		User user2 = createUser();
		user2.setEmail("TestEmail2");
		Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(user2);
		userService.putById(id, user2);
	}
	
	private User createUser() {
		User user = new User();
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");
		user.setEmail("TestEmail");
		user.setPicture("TestPicture");
		user.setScore(95);
		return user;
	}
}
