package br.com.castgroup.personsrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.castgroup.personsrest.entity.Person;
import br.com.castgroup.personsrest.exception.InvalidIdException;
import br.com.castgroup.personsrest.exception.PersonNotFoundException;
import br.com.castgroup.personsrest.service.PersonService;

/**
 * Class that represents the restful entrypoints.
 * @author alsantos
 *
 */
@RestController
@RequestMapping("/rest")
public class PersonController {

	@Autowired
	private PersonService service;

	/**
	 * A get method to find a personal by the id.
	 * @param id the identifier of the person.
	 * @return the person.
	 * @throws InvalidIdException if an invalid number was passed as argument.
	 * @throws PersonNotFoundException if the person was not found in repository.
	 */
	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<Person> find(@PathVariable("id") String id) throws InvalidIdException, PersonNotFoundException {

		return ResponseEntity.ok(service.find(id));
	}

	/**
	 * A post method for saving a person in repository.
	 * @param requestPerson the person to be inserted.
	 * @return the person inserted.
	 */
	@RequestMapping(value = "/pessoa/save", method = RequestMethod.POST, produces = "application/json")
	public HttpEntity<Person> save(@RequestBody Person requestPerson) {

		return ResponseEntity.ok(service.save(requestPerson));
	}
	
	/**
	 * A post method to remove a personal from repository.
	 * @param id the identifier of the person.
	 * @return the person removed.
	 * @throws InvalidIdException if an invalid number was passed as argument.
	 * @throws PersonNotFoundException if the person was not found in repository.
	 */
	@RequestMapping(value = "/pessoa/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public HttpEntity<Person> remove(@PathVariable("id") String id) throws InvalidIdException, PersonNotFoundException {

		return ResponseEntity.ok(service.remove(id));
	}
	
	/**
	 * A get method to list all the persons in repository.
	 * @return the list of persons.
	 */
	@RequestMapping(value = "/pessoas", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<Iterable<Person>> list() {

		return ResponseEntity.ok(service.list());
	}

}
