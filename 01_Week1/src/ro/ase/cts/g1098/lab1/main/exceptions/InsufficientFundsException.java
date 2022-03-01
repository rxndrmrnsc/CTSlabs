package ro.ase.cts.g1098.lab1.main.exceptions;

public class InsufficientFundsException extends Exception {
	// there are 2 types of exceptions in Java: checked and unchecked
	// this is a checked exception
	
	public InsufficientFundsException() {
		
	}
	
	public InsufficientFundsException(String msg) {
		super(msg);
	}
	
}
