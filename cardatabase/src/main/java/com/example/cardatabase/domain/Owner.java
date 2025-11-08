package com.example.cardatabase.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long OnwerId;
	private String firstname, lastname;
	
	public Owner() { }
	
	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
//	if the owner is deleted, the cars that are linked to that owner are deleted as well. 
//	The mappedBy="owner" attribute setting tells us that the Car class has the owner field,
// Important: prevent infinite loop by ignoring this in JSON
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private List<Car> cars;
	    
	public List<Car> getCars() {
	    return cars;
	}
	
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

//if we wanted many to many:
//	 @ManyToMany(cascade=CascadeType.PERSIST)
//	 @JoinTable(name="car_owner",joinColumns = 
//	        {
//	        @JoinColumn(name="ownerid") },
//	        inverseJoinColumns = 
//	        {
//	        @JoinColumn(name="id") }
//	 )
//	 private Set<Car> cars = new HashSet<Car>();
//	 public Set<Car> getCars() {
//	    return cars;
//	 }
	public Long getOnwerId() {
		return OnwerId;
	}

	public void setOnwerId(Long onwerId) {
		OnwerId = onwerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	

	
}
