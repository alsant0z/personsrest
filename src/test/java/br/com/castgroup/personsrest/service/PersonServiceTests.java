package br.com.castgroup.personsrest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.castgroup.personsrest.entity.Person;
import br.com.castgroup.personsrest.exception.InvalidIdException;
import br.com.castgroup.personsrest.exception.PersonNotFoundException;

/**
 * 
 * Unit tests
 * @author alsantos
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTests {
	@Autowired
	private PersonService service;
	
	@Test(expected = InvalidIdException.class)
    public void testFindWithNull() throws InvalidIdException, PersonNotFoundException {
        service.find(null);
    }
	
	@Test(expected = InvalidIdException.class)
    public void testFindWithEmpty() throws InvalidIdException, PersonNotFoundException {
        service.find("");
    }
	
	@Test(expected = InvalidIdException.class)
    public void testFindWithAlphabetical() throws InvalidIdException, PersonNotFoundException {
        service.find("a");
    }
	
	@Test(expected = PersonNotFoundException.class)
    public void testFindNotFoundException() throws InvalidIdException, PersonNotFoundException {
        service.find("1");
    }
	
	@Test(expected = InvalidIdException.class)
    public void testRemoveWithNull() throws InvalidIdException, PersonNotFoundException {
        service.remove(null);
    }
	
	@Test(expected = InvalidIdException.class)
    public void testRemoveWithEmpty() throws InvalidIdException, PersonNotFoundException {
        service.remove("");
    }
	
	@Test(expected = InvalidIdException.class)
    public void testRemoveWithAlphabetical() throws InvalidIdException, PersonNotFoundException {
        service.remove("a");
    }
	
	@Test(expected = PersonNotFoundException.class)
    public void testRemoveNotFoundException() throws InvalidIdException, PersonNotFoundException {
        service.remove("1");
    }
	
	@Test
    public void testAddLeftWithRightSideNull() {
		Person person = new Person();
		person.setId(-1); // will be ignored
		person.setName("Alexandre Santos");
		person.setCellphone("81988330423");
		person.setCity("Recife");
		person.setState("Pernambuco");
		person.setNumber("1847");
		person.setPhone("8134312003");
		person.setStreet("Rua dos Navegantes.");
		
		person = service.save(person);
		
		assertEquals(person.getId(), 1L);
		assertEquals(person.getCellphone(), "81988330423");
		assertEquals(person.getName(), "Alexandre Santos");
		assertEquals(person.getCity(), "Recife");
		assertEquals(person.getState(), "Pernambuco");
		assertEquals(person.getNumber(), "1847");
		assertEquals(person.getPhone(), "8134312003");
		assertEquals(person.getStreet(), "Rua dos Navegantes.");
               
    }
	
}
