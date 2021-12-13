package com.bae.animals.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

//boots the entire context - random port to avoid collisions
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMvc object
@Sql(scripts = { "classpath:Animal-schema.sql",
"classpath:Animal-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)


@ActiveProfiles("test")
public class AnimalControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	
	@Autowired
	private ObjectMapper mapper;
	
	
	
	
	@Test
	void testCreate() throws Exception {
		Animal testAnimal = new Animal("bird", 50, "blue", true);
		String testAnimalAsJSON = this.mapper.writeValueAsString(testAnimal);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testAnimalAsJSON);
		
		Animal testCreatedAnimal = new Animal(1, "bird", 50, "blue", true);
		String testCreatedAnimalAsJSON = this.mapper.writeValueAsString(testCreatedAnimal);
		ResultMatcher checkStatus = status().isCreated(); // is status 201 created
		ResultMatcher checkBody = content().json(testCreatedAnimalAsJSON); // does the body match my testCreateCatAsJSON
		
		// sends request - checks the status- checks the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
