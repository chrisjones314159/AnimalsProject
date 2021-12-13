package com.bae.animals.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

	
	
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

	
	
	
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Animal(String name, int age, String colour, boolean isCute) {
		super();
		this.name = name;
		this.age = age;
		this.colour = colour;
		this.isCute = isCute;
	}


	
	
	public Animal(Integer id, String name, int age, String colour, boolean isCute) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.colour = colour;
		this.isCute = isCute;
	}


	
	
	
	
	
	
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


	
	
	
	
	
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", age=" + age + ", colour=" + colour + ", isCute=" + isCute
				+ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, colour, id, isCute, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return age == other.age && Objects.equals(colour, other.colour) && Objects.equals(id, other.id)
				&& isCute == other.isCute && Objects.equals(name, other.name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
