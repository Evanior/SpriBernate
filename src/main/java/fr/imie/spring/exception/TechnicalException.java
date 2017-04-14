package fr.imie.spring.exception;

public class TechnicalException extends RuntimeException{
	public TechnicalException(Exception cause){
		super(cause);
	}
}
