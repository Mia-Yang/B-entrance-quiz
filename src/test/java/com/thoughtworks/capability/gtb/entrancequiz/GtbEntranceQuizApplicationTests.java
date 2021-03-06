package com.thoughtworks.capability.gtb.entrancequiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GtbEntranceQuizApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void should_get_name_list() throws Exception {
		mockMvc.perform(get("/list"))
				.andExpect(jsonPath("$", hasSize(37)))
				.andExpect(jsonPath("$[0].id",is(1)))
				.andExpect(jsonPath("$[0].name",is("廖浚斌")))
				.andExpect(status().isOk());
	}

	@Test
	void should_add_new_person() throws Exception {
		Person person = new Person(38, "杨恒宇");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(person);
		mockMvc.perform(post("/list").content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc.perform(get("/list"))
				.andExpect(jsonPath("$", hasSize(38)))
				.andExpect(jsonPath("$[37].id",is(38)))
				.andExpect(jsonPath("$[37].name",is("杨恒宇")))
				.andExpect(status().isOk());
	}
}
