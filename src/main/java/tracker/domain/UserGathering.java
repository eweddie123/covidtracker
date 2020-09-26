package tracker.domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class UserGathering {
	
	@EmbeddedId
	private UserGatheringId id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@MapsId("userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@MapsId("gatheringId")
	private Gathering gathering;
	
    @Column(name = "score")
	private Integer score;
	
    @Column(name = "mask")
	private boolean mask;
	
	private UserGathering() {
		
	}
	
	public UserGathering(User user, Gathering gathering) {
		this.user = user;
		this.gathering = gathering;
		this.id = new UserGatheringId(user.getId(), gathering.getId());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o ==null || getClass() != o.getClass()) return false;
		
		UserGathering that = (UserGathering) o;
		return Objects.equals(user, that.user) && Objects.equals(gathering, that.gathering);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(user, gathering);
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setMask(boolean mask) {
		this.mask = mask;
	}
	
	public boolean getMask() {
		return mask;
	}
}
