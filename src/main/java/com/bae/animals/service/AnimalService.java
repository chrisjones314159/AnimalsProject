package com.bae.animals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.animals.domain.Animal;
import com.bae.animals.repo.AnimalRepo;

@Service
public class AnimalService {

	private AnimalRepo repo;
	
	
	@Autowired
	public AnimalService(AnimalRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	public Animal createAnimal(Animal animal) {
		Animal created = this.repo.save(animal);
		return created;
	}

	public List<Animal> getAllAnimals() {
		return this.repo.findAll();
	}

	public Animal getAnimal(Integer id) {
		Optional<Animal> found = this.repo.findById(id);
		return found.get();
	}
	public List<Animal> getAllAnimalsByName(String name) {
		List<Animal> found = this.repo.findByNameIgnoreCase(name);
		return found;
	}

	public Animal replaceAnimal(Integer id, Animal newAnimal) {
		Animal existing = this.repo.findById(id).get();
		
		existing.setName(newAnimal.getName());
		existing.setAge(newAnimal.getAge());
		existing.setColour(newAnimal.getColour());
		existing.setCute(newAnimal.isCute());
		
		Animal updated = this.repo.save(existing);

		return updated;
	}

	public void removeAnimal(Integer id) {
		this.repo.deleteById(id);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
