package tracker.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tracker.domain.Gathering;
import tracker.repository.GatheringRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GatheringServiceTest {
	
	@Autowired 
	private GatheringService gatheringService;
	
	@MockBean
	private GatheringRepository gatheringRepository;
	
	@Test
	public void findByIdTest() {
		int id = 20;
		Gathering gathering = createGathering();
		Mockito.when(gatheringRepository.findById(anyInt())).thenReturn(Optional.of(gathering));
		Optional<Gathering> foundGathering = gatheringService.findById(id);
		assertEquals(foundGathering.get().getGatheringName(), "TestGatheringName");
	}
	
	private Gathering createGathering() {
		Gathering gathering = new Gathering();
		LocalDateTime date = LocalDateTime.now();
		gathering.setDateTime(date);
		gathering.setDescription("TestDescription");
		gathering.setGatheringName("TestGatheringName");
		gathering.setLocation("TestLocation");
		gathering.setOrganizerId(90);	
		return gathering;
	}
}
