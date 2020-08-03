package tracking;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Gathering {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer gatheringId;
	
	@NotNull
    @Column(name = "organizer_id")
	private Integer organizerId;
	
	@NotNull
    @Column(name = "gathering_name")
	private String gatheringName;
	
	@NotNull
    @Column(name = "datetime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
	
	@NotNull
    @Column(name = "location")
	private String location;
	
	public Integer getGatheringId() {
		return gatheringId;
	}
	
	public void setOrganizerId(Integer organizerId) {
		this.organizerId = organizerId;
	}
	
	public Integer getOrganizerId() {
		return organizerId;
	}
	
	public void setGatheringName(String gatheringName) {
		this.gatheringName = gatheringName;
	}
	
	public String getGatheringName() {
		return   gatheringName;
	}
	
	@Transactional
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	@Transactional
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
}
