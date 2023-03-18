package com.sunilOS.ORSProject3.exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 * 
 * @author Rishabh Gurjar
 *
 */

public class RecordNotFoundException extends Exception{

	
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 *      : Error message
	 */
	public RecordNotFoundException(String msg){
		
		super(msg);
	}
}
