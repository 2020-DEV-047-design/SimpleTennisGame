package com.game.tennis.pojo;

/**
 * This class has the player information
 * @author 2020-DEV-047
 *
 */
public class Player {
	
	private String name;
	private int points;

	public Player(String playerName) {
		this.name = playerName;
	}

	/**
	 * Returns the player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns points stored in a player's bucket
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets points to a player's bucket
	 * 
	 * @param points
	 *            - An int data type
	 */
	public void setPoints(int points) {
		this.points = points;
	}
}
