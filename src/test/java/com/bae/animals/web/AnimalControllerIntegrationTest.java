package com.bae.animals.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;


import com.bae.animals.domain.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:Animal-schema.sql",
"classpath:Animal-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)


@ActiveProfiles("test")
public class AnimalControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	
	@Autowired
	private ObjectMapper mapper;
	
	
	
	// Tests for each method used in AnimalConntroller class
	@Test
	void testCreate() throws Exception {
		Animal testAnimal = new Animal("bird", 50, "blue", true, "test.png");
		String testAnimalAsJSON = this.mapper.writeValueAsString(testAnimal);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testAnimalAsJSON);
		
		Animal testCreatedAnimal = new Animal(2, "bird", 50, "blue", true, "test.png");
		String testCreatedAnimalAsJSON = this.mapper.writeValueAsString(testCreatedAnimal);
		ResultMatcher checkStatus = status().isCreated(); 
		ResultMatcher checkBody = content().json(testCreatedAnimalAsJSON); 
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getAllTest() throws Exception {
		List<Animal> testAnimals = List.of(new Animal(1, "kangaroo", 15, "brown", true, "test.png"));
		String json = this.mapper.writeValueAsString(testAnimals);
		
		
		RequestBuilder req = get("/getAll");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	@Test
	void getAnimalTest() throws Exception {
		Animal testAnimal = new Animal(1, "kangaroo", 15, "brown", true, "test.png");
		String json = this.mapper.writeValueAsString(testAnimal);
		
		RequestBuilder req = get("/get/1");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
	
	
	
	@Test
	void getAnimalByNameTest() throws Exception {
		List<Animal> testAnimal = List.of(new Animal(1, "kangaroo", 15, "brown", true, "test.png"));
		String json = this.mapper.writeValueAsString(testAnimal);
		
		RequestBuilder req = get("/getByName/kangaroo");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
	
	@Test
	void replaceTest() throws Exception {
		Animal testAnimal = new Animal("dog", 4, "brown", true, "test.png");
		String testAnimalAsJSON = this.mapper.writeValueAsString(testAnimal);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testAnimalAsJSON);
		
		Animal testCreatedAnimal = new Animal(1, "dog", 4, "brown", true, "test.png");
		String testCreatedAnimalAsJSON = this.mapper.writeValueAsString(testCreatedAnimal);
		ResultMatcher checkStatus = status().isAccepted(); 
		ResultMatcher checkBody = content().json(testCreatedAnimalAsJSON); 
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	@Test
	void deleteTest() throws Exception {
		RequestBuilder req = delete("/remove/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(req).andExpect(checkStatus);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
