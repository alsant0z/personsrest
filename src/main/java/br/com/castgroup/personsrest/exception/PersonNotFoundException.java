package br.com.castgroup.personsrest.exception;

/**
 * A class that represents an exception when the person was not found in repository.
 * @author alsantos
 *
 */
public class PersonNotFoundException extends Exception {
	private static final String MSG = "Person not found in repository. Please, try again.";
	public PersonNotFoundException() {
		super(MSG);
	}
}
