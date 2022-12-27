package com.example.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.helper.TestHelper;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class StaticPagesControllerTest extends TestHelper {
	
	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("Homeページの表示")
	void shouldGetHome() throws Exception {
		
		mockMvc.perform(
				get("/")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("static_pages/home"))
		.andExpect(content().string(containsString(fullTitle(""))));
		
	}
	
	@Test
	@DisplayName("Helpページの表示")
	void shouldGetHelp() throws Exception {
		
		mockMvc.perform(
				get("/help")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("static_pages/help"))
		.andExpect(content().string(containsString(fullTitle("Help"))));
		
	}
	
	@Test
	@DisplayName("Aboutページの表示")
	void shouldGetAbout() throws Exception {
		
		mockMvc.perform(
				get("/about")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("static_pages/about"))
		.andExpect(content().string(containsString(fullTitle("About"))));
		
	}

}
