package tracker.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tracker.domain.UserGathering;

public interface UserGatheringRepository extends CrudRepository<UserGathering, Integer> {
	
	Iterable<Optional<UserGathering>> findByGatheringId(Integer gatheringId);

	Iterable<Optional<UserGathering>> findByUserId(Integer userId);
	
	Optional<UserGathering> findByUserIdAndGatheringId(Integer userId, Integer gatheringId);
}
