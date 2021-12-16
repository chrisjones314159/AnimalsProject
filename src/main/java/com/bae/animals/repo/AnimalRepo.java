package com.bae.animals.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.animals.domain.Animal;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Integer> {
	
	// List used for the search by name function.
	List<Animal> findByNameIgnoreCase(String name);

}
