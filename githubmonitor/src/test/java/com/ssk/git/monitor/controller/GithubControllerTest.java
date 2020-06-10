package com.ssk.git.monitor.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

@WebMvcTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { GithubController.class, RestTemplate.class })
public class GithubControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	RestTemplate restTemplate;

	@Test
	public void testGetEventSuccess() throws Exception {

		String result = testGetEvent("skhidake", "githubmonitor");
		assertNotNull(result);

	}

	@Test
	public void testGetEventFailed1() throws Exception {

		String result = testGetEvent("skhidake_wrong", "githubmonitor");
		assertNull(result);

	}

	@Test
	public void testGetEventFailed2() throws Exception {

		String result = testGetEvent("skhidake", "githubmonitor_wrong");
		assertNull(result);

	}

	private String testGetEvent(String owner, String repo) throws Exception {
		try {
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/" + owner + "/" + repo + "/events"))
					.andExpect(status().isOk()).andReturn();
			return result.getResponse().getContentAsString();
		} catch (Exception e) {
			return null;
		}
		// assertEquals(czs, resultCZ);
	}

}
