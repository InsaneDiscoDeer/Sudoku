package no.ntnu.imt3281.sudoku;

public class BadNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadNumberException() {
		super();
	}
	
	public BadNumberException(String message) {
		super(message);
	}

}
