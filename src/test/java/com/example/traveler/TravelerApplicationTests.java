package com.example.traveler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.traveler.Controller.TravelerController;
import com.example.traveler.Model.Traveler;
import com.example.traveler.Repository.TravelerRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class TravelerApplicationTests {

	private MockMvc mvc;
	@Mock
	private TravelerRepo travRepo;

	@InjectMocks
	private TravelerController travelerController;

	private JacksonTester<Traveler> jsonTraveler;


	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(travelerController).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddaTraveler() throws Exception {

		Traveler trvl = new Traveler(1L, "ali", "ali@gmail.com", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
    //    when(bookRepository.save(book)).thenReturn((book));
		mvc.perform(post("/traveler/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonTraveler.write(trvl).getJson()))
				.andExpect(status().isOk());

	}

}
