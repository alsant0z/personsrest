package br.com.castgroup.personsrest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.castgroup.personsrest.entity.Person;
import br.com.castgroup.personsrest.repository.PersonRepository;

/**
 * Integration tests
 * 
 * @author alsantos
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerIT {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private PersonController controller;
	
	@Autowired
	private PersonRepository repository;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testSave() throws Exception {
		Person person = new Person();
		person.setId(-1); // will be ignored
		person.setName("Alexandre Santos");
		person.setCellphone("81988330423");
		person.setCity("Recife");
		person.setState("Pernambuco");
		person.setNumber("1847");
		person.setPhone("8134312003");
		person.setStreet("Rua dos Navegantes.");
		Gson gson = new Gson();
		System.out.println("####" + gson.toJson(person));
		mvc.perform(MockMvcRequestBuilders.post("/rest/pessoa/save").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(person))).andExpect(status().isOk()).andReturn();
		Optional<Person> data = repository.findById(1L);
		assertNotNull(data.get());
		assertEquals(data.get().getId(), 1L);
		assertEquals(data.get().getCellphone(), "81988330423");
		assertEquals(data.get().getName(), "Alexandre Santos");
		assertEquals(data.get().getCity(), "Recife");
		assertEquals(data.get().getState(), "Pernambuco");
		assertEquals(data.get().getNumber(), "1847");
		assertEquals(data.get().getPhone(), "8134312003");
		assertEquals(data.get().getStreet(), "Rua dos Navegantes.");
	}
	

}
