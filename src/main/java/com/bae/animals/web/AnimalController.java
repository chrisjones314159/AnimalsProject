package com.bae.animals.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.animals.domain.Animal;
import com.bae.animals.service.AnimalService;

@CrossOrigin
@RestController

public class AnimalController {

	private AnimalService service;
	
	
	
	@Autowired
	
	
	
	public AnimalController(AnimalService service) {
		super();
		this.service = service;
	}
	
	
	
	
	
	@PostMapping("/create") // 201 - Created
	public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
		Animal created = this.service.createAnimal(animal);
		ResponseEntity<Animal> response = new ResponseEntity<Animal>(created, HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/getAll") // 200 - OK
	public ResponseEntity<List<Animal>> getAllAnimals() {
		return ResponseEntity.ok(this.service.getAllAnimals());
	}

	@GetMapping("/get/{id}") // 200 - OK
	public Animal getAnimal(@PathVariable Integer id) {
		return this.service.getAnimal(id);
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Animal>> getAnimalByName(@PathVariable String name) {
		return ResponseEntity.ok(this.service.getAllAnimalsByName(name));
	}

	@PutMapping("/replace/{id}") // 202 - Accepted
	public ResponseEntity<Animal> replaceAnimal(@PathVariable Integer id, @RequestBody Animal newAnimal) {
		Animal body = this.service.replaceAnimal(id, newAnimal);

		ResponseEntity<Animal> response = new ResponseEntity<Animal>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}") // 204
	public ResponseEntity<?> removeAnimal(@PathVariable Integer id) {
		this.service.removeAnimal(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
