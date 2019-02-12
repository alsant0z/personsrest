package br.com.castgroup.personsrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.castgroup.personsrest.entity.Person;

/**
 * A Crud implementation of the repository for Persons.
 * @author alsantos
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
