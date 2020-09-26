package tracker.domain;

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

@Entity 
@Table(name="user")
public class User {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserGathering> userGatherings = new ArrayList<>();

	@NotNull
    @Column(name = "first_name")
  	private String firstName;
	
	@NotNull
    @Column(name = "last_name")
  	private String lastName;
  	
	@NotNull
    @Column(name = "email")
	private String email;
  
	@NotNull
    @Column(name = "score")
	private Integer score;
	
    @Column(name = "picture")
	private String picture;
	
	public List<UserGathering> getUserGatherings() {
		return userGatherings;
	}

	public void setUserGatherings(List<UserGathering> userGatherings) {
		this.userGatherings = userGatherings;
	}

  	public Integer getId() {
	  	return id;
  	}

  	public String getFirstName() {
	  	return firstName;
  	}

  	public void setFirstName(String firstName) {
	  	this.firstName = firstName;
  	}
  	
  	public String getLastName() {
	  	return lastName;
  	}

  	public void setLastName(String lastName) {
	  	this.lastName = lastName;
  	}
  	
  	public String getEmail() {
	  	return email;
  	}

  	public void setEmail(String email) {
	  	this.email = email;
  	}
  	
  	public Integer getScore() {
	  	return score;
  	}

  	public void setScore(Integer score) {
	  	this.score = score;
  	}
  	
  	public String getPicture() {
	  	return picture;
  	}

  	public void setPicture(String picture) {
	  	this.picture = picture;
  	}
  	
  	public void addGathering(Gathering gathering) {
  		UserGathering userGathering = new UserGathering(this, gathering);
  		this.userGatherings.add(userGathering);
  		gathering.getUserGatherings().add(userGathering);
  	}
  	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o ==null || getClass() != o.getClass()) return false;
		
		User that = (User) o;
		return Objects.equals(this.id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}
