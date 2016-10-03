package com.simscale.assignment;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserCatalogServiceApplication.class)
public class UserCatalogServiceApplicationTest {
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void shouldReturnOKForAllUsersResourceURI() throws Exception {
		this.mvc.perform(get("/users/"))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldReturnSuccessForPutAndGetUser() throws Exception {
		this.mvc.perform(put("/users/guilherme.cardoso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"firstName\": \"Guilherme\", \"lastName\": \"Cardoso\" }"))
				.andExpect(status().is2xxSuccessful());

		this.mvc.perform(get("/users/guilherme.cardoso"))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldReturnNotFoundForUserNotCreatedPreviously() throws Exception {

		this.mvc.perform(get("/users/cardoso.guilherme"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void shouldReturnMethodNotAllowedWhenDelete() throws Exception {
		this.mvc.perform(delete("/users/guilherme.cardoso"))
				.andExpect(status().isMethodNotAllowed());
	}
}

