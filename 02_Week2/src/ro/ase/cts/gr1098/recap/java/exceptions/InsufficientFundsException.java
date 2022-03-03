package ro.ase.cts.gr1098.recap.java.exceptions;

public class InsufficientFundsException extends Exception {

	// Exception or RuntimeException
	// Exception makes you use try/catch or throws
	// RuntimeExceptions only appear at runtime
	
	public InsufficientFundsException() {
		
	}
	
	public InsufficientFundsException(String msg) {
		super(msg);
	}
}
