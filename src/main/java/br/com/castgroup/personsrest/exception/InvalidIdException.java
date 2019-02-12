package br.com.castgroup.personsrest.exception;

/**
 * A class that represents an exception, that is thrown when an invalid id was passed.
 * @author alsantos
 *
 */
public class InvalidIdException extends Exception {
	private static final String MSG = "Invalid id. Please, use a valid nunber.";
	public InvalidIdException() {
		super(MSG);
	}
}
