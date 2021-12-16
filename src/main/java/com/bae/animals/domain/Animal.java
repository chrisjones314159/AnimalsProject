package com.bae.animals.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

	
	
	// Variables
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String colour;
	
	@Column(nullable = false)
	private boolean isCute;
	
	private String imageUrl;

	
	
	
	// Constructors; 1 empty, 1 without id and 1 with id
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Animal(String name, int age, String colour, boolean isCute, String imageUrl) {
		super();
		this.name = name;
		this.age = age;
		this.colour = colour;
		this.isCute = isCute;
		this.imageUrl = imageUrl;
	}


	
	
	public Animal(Integer id, String name, int age, String colour, boolean isCute, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.colour = colour;
		this.isCute = isCute;
		this.imageUrl = imageUrl;
	}


	
	
	
	
	// Getters and Setters 
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public boolean isCute() {
		return isCute;
	}


	public void setCute(boolean isCute) {
		this.isCute = isCute;
	}

	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
