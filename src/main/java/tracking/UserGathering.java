package tracking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserGathering {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userGatheringId;
	
	@NotNull
    @Column(name = "user_id")
	private Integer userId;
	
	@NotNull
    @Column(name = "gathering_id")
	private Integer gatheringId;
	
	@NotNull
    @Column(name = "status")
	private String status;
	
	@NotNull
    @Column(name = "mask")
	private boolean mask;
	
	public Integer getUserGatheringId() {
		return userGatheringId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setGatheringId(Integer gatheringId) {
		this.gatheringId = gatheringId;
	}
	
	public Integer getGatheringId() {
		return gatheringId;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setMask(boolean mask) {
		this.mask = mask;
	}
	
	public boolean getMask() {
		return mask;
	}
}
