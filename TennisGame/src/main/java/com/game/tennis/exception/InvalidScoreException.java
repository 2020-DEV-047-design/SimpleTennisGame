/**
 * 
 */
package com.game.tennis.exception;

/**
 * This is an exception class to handle illegal points provided in Tennis Game
 * @author 2020-DEV-047
 *
 */
@SuppressWarnings("serial")
public class InvalidScoreException extends RuntimeException {

	public InvalidScoreException(String message){
		super(message);
	}
}
