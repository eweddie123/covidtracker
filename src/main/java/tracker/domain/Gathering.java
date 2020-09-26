package tracker.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "gathering")
public class Gathering {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "gathering", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserGathering> userGatherings = new ArrayList<>();
	
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
	
	@NotNull
    @Column(name = "description")
	private String description;
	
	public List<UserGathering> getUserGatherings() {
		return userGatherings;
	}

	public void setUserGatherings(List<UserGathering> userGatherings) {
		this.userGatherings = userGatherings;
	}
	
	public Integer getId() {
	  	return id;
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
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	} 
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o ==null || getClass() != o.getClass()) return false;
		
		Gathering that = (Gathering) o;
		return Objects.equals(this.id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}
