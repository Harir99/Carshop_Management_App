package com.example.cardatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    private String brand, model, color, registrationNumber;
    
    private int modelYear, price;
    
    // Car.java constructors
    public Car() { }
    
    public Car(String brand, String model, String color,
    		String registrationNumber, int modelYear, int price, Owner owner) {
           super();
           this.brand = brand;
           this.model = model;
           this.color = color;
           this.registrationNumber = registrationNumber;
           this.modelYear = modelYear;
           this.price = price;
           this.owner = owner;
           
    }
    
//  LAZY strategy means that when the owner is fetched from the database, 
//  the cars associated with the owner will be fetched when needed. EAGER means that the cars
//  will be fetched immediately by the owner. 
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="owner") // matches the "owner" column in your car table
    private Owner owner;
    
    // Getter and setter
    public Owner getOwner() {
       return owner;
    }
    
    public void setOwner(Owner owner) {
       this.owner = owner;
    }
    
//If you want many to many:
//    @ManyToMany(mappedBy="cars")
//    private Set<Owner> owners = new HashSet<Owner>();
//    public Set<Owner> getOwners() {
//       return owners;
//    }
//    public void setOwners(Set<Owner> owners) {
//       this.owners = owners;
//    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public String getBrand() {
        return brand;
	}
    
	public void setBrand(String brand) {
	        this.brand = brand;
	}
	
	public String getModel() {
	        return model;
	}
	
	public void setModel(String model) {
	        this.model = model;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	public int getModelYear() {
		return modelYear;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
}


