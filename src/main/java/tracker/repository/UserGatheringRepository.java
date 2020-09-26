package tracker.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tracker.domain.UserGathering;

@Repository
public interface UserGatheringRepository extends CrudRepository<UserGathering, Integer> {
	
	Iterable<Optional<UserGathering>> findByGatheringId(Integer gatheringId);

	Iterable<Optional<UserGathering>> findByUserId(Integer userId);
	
	Optional<UserGathering> findByUserIdAndGatheringId(Integer userId, Integer gatheringId);
}
