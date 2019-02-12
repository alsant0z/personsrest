package br.com.castgroup.personsrest.service;

import br.com.castgroup.personsrest.entity.Person;
import br.com.castgroup.personsrest.exception.InvalidIdException;
import br.com.castgroup.personsrest.exception.PersonNotFoundException;

/**
 * This interface provides the operations available with the person entity.
 * 
 * @author alsantos
 *
 */
public interface PersonService {

	/**
	 * Finds a personal by the id.
	 * @param id the identifier of the person.
	 * @return the person.
	 * @throws InvalidIdException if an invalid number was passed as argument.
	 * @throws PersonNotFoundException if the person was not found in repository.
	 */
	Person find(String id) throws InvalidIdException, PersonNotFoundException;

	/**
	 * Saves a person in repository.
	 * @param requestPerson the person to be inserted.
	 * @return the person inserted.
	 */
	Person save(Person person);

	/**
	 * Removes a personal from repository.
	 * @param id the identifier of the person.
	 * @return the person removed.
	 * @throws InvalidIdException if an invalid number was passed as argument.
	 * @throws PersonNotFoundException if the person was not found in repository.
	 */
	Person remove(String id) throws InvalidIdException, PersonNotFoundException;

	/**
	 * Lists all the persons in repository.
	 * @return the list of persons.
	 */
	Iterable<Person> list();
}
