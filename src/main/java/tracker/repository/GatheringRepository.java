package tracker.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tracker.domain.Gathering;

@Repository
public interface GatheringRepository extends CrudRepository<Gathering, Integer> {

	Iterable<Optional<Gathering>> findByLocation(String location);
	
	Iterable<Optional<Gathering>> findByGatheringName(String gatheringName);
	
	Iterable<Optional<Gathering>> findByOrganizerId(Integer organizerId);
	
}