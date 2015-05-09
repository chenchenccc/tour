package com.tour.commons.utils;

/**
 * 
 * @author chenrh
 * @date 2015-5-8
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {
	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
}
