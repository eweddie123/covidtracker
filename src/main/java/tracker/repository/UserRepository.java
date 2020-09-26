package tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tracker.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Iterable<Optional<User>> findByLastName(String lastName);
}