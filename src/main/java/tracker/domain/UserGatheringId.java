package tracker.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserGatheringId implements Serializable{
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "gathering_id")
	private Integer gatheringId;
	
	private UserGatheringId() {
	}
	
	public UserGatheringId(Integer userId, Integer gatheringId) {
		this.userId = userId;
		this.gatheringId = gatheringId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o ==null || getClass() != o.getClass()) return false;
		
		UserGatheringId that = (UserGatheringId) o;
		return Objects.equals(userId, that.userId) && Objects.equals(gatheringId, that.gatheringId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId, gatheringId);
	}
}
