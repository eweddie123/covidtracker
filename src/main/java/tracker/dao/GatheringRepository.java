package tracker.dao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tracker.domain.Gathering;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GatheringRepository extends CrudRepository<Gathering, Integer> {

	Iterable<Optional<Gathering>> findByLocation(String location);
	
	Iterable<Optional<Gathering>> findByGatheringName(String gatheringName);
	
	//Iterable<Optional<Gathering>> findByDate(Date dateTime);
	
	Iterable<Optional<Gathering>> findByOrganizerId(Integer organizerId);
}