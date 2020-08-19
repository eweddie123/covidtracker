package tracker.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tracker.domain.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
	
	Iterable<Optional<User>> findByLastName(String lastName);
}