package tracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tracker.domain.Gathering;
import tracker.repository.GatheringRepository;

@Service
public class GatheringService {

	private GatheringRepository gatheringRepository;
	@Autowired
	public void setGatheringRepository(GatheringRepository gatheringRepository) {
		this.gatheringRepository = gatheringRepository;
	}
	
	public void save(Gathering gathering) {
		gatheringRepository.save(gathering);
	}
	
	public void deleteById(Integer id) {
		gatheringRepository.deleteById(id);
	}
	
	public void putById(Integer id, Gathering editGathering) {
		findById(id)
		.map(gathering -> {
			gathering.setGatheringName(editGathering.getGatheringName());
			gathering.setDateTime(editGathering.getDateTime());
			gathering.setLocation(editGathering.getLocation());
			gathering.setDescription(editGathering.getDescription());
			return gatheringRepository.save(gathering);
		});
	}
	
	public Optional<Gathering> findById(Integer id) {
		return gatheringRepository.findById(id);
	}
	
	public Iterable<Gathering> findAll() {
		return gatheringRepository.findAll();
	}
}
