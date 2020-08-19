package tracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
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
	
  	public Integer getUserId() {
	  	return userId;
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
}
