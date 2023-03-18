package com.sunilOS.ORSProject3.exception;

/**
 *  DuplicateRecordException thrown when a duplicate record occurred
 *
 * @author Rishabh Gurjar
 *
 */

public class DuplicateRecordException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 * error msg
	 */
	public DuplicateRecordException(String msg){
		super(msg);
	}

}
