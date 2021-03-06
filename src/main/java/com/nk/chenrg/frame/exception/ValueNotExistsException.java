package com.nk.chenrg.frame.exception;

/**
 * 集合内值已经存在
 * 
 * @author chenrg 2011-9-26
 */
public class ValueNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValueNotExistsException() {
		super();
	}

	public ValueNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValueNotExistsException(String message) {
		super(message);
	}

	public ValueNotExistsException(Throwable cause) {
		super(cause);
	}

}
