package br.com.castgroup.personsrest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.castgroup.personsrest.entity.Person;
import br.com.castgroup.personsrest.exception.InvalidIdException;
import br.com.castgroup.personsrest.exception.PersonNotFoundException;
import br.com.castgroup.personsrest.repository.PersonRepository;
import br.com.castgroup.personsrest.service.PersonService;

/**
 * The implementation of the service interface.
 * @author alsantos
 *
 */
@Service
public class PersonSerivceImpl implements PersonService {
	
	@Autowired
	private PersonRepository repository;

	@Override
	public Person find(String id) throws InvalidIdException, PersonNotFoundException {
		validateId(id);
		
		Optional<Person> optionalPerson = repository.findById(Long.parseLong(id));
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			throw new PersonNotFoundException();
		}
	}

	@Override
	public Person save(Person person) {
		return repository.save(person);
	}

	@Override
	public Person remove(String id) throws InvalidIdException, PersonNotFoundException {
		validateId(id);
		
		Optional<Person> optionalPerson = repository.findById(Long.parseLong(id));
		if (optionalPerson.isPresent()) {
			repository.delete(optionalPerson.get());
			return optionalPerson.get();
		} else {
			throw new PersonNotFoundException();
		}
	}

	@Override
	public Iterable<Person> list() {
		return repository.findAll();
	}
	
	/**
	 * Valides the id passed to the person.
	 * @param id the identifier passed as argument.
	 * @throws InvalidIdException if an invalid id was passed as argument.
	 */
	private void validateId(String id) throws InvalidIdException {
		if (id == null || id.trim().isEmpty()) {
			throw new InvalidIdException();
		}
		
		// to test if it is a valid long
		try {
			Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new InvalidIdException();
		}
	}

}
