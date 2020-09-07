package com.thoughtworks.capability.gtb.entrancequiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
		mockMvc.perform(get("/nameList"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].id",is(1)))
				.andExpect(jsonPath("$[0].name",is("杨思雨")))
				.andExpect(jsonPath("$[1].id",is(2)))
				.andExpect(jsonPath("$[1].name",is("黄云洁")))
				.andExpect(jsonPath("$[2].id",is(3)))
				.andExpect(jsonPath("$[2].name",is("贠晨曦")))
				.andExpect(status().isOk());
	}
}
