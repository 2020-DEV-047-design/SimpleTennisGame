package com.game.tennis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.game.tennis.TennisGame;
import com.game.tennis.exception.InvalidScoreException;
import com.game.tennis.pojo.Player;
import com.game.tennis.util.TennisGameConstants;

/**
 * The class is used to check/test the functionalities in TennisGame
 * 
 * @author 2020-DEV-047
 * 
 */

public class TennisGameTest {

	private TennisGame tennisGame, tennisMatch;
	private Player player1, player2;

	@Before
	public void Setup() {
		tennisGame = new TennisGame(null, null);
		player1 = new Player(TennisGameConstants.PLAYER_1_NAME);
		player2 = new Player(TennisGameConstants.PLAYER_2_NAME);
		tennisMatch = new TennisGame(player1, player2);
	}

	/**
	 * Test case to get the score description that will be scored by a player
	 * points{0,1,2,3} These values correspond to {LOVE,FIFTEEN,THIRTY,FORTY}
	 */
	@Test
	public void testScoreDescForLove_Fifteen_Thirty_Forty() {
		assertEquals(TennisGameConstants.SCORE_LOVE, tennisGame.getScoreDesc(0));
		assertEquals(TennisGameConstants.SCORE_FIFTEEN, tennisGame.getScoreDesc(1));
		assertEquals(TennisGameConstants.SCORE_THIRTY, tennisGame.getScoreDesc(2));
		assertEquals(TennisGameConstants.SCORE_FORTY, tennisGame.getScoreDesc(3));
	}

	/**
	 * Test case to check for an exception in case any invalid point is supplied
	 * as score Any value apart from {0,1,2,3} are the invalid points
	 */
	@Test(expected = InvalidScoreException.class)
	public void testScoreDescForValueOtherThan_0_1_2_3_ThrowsException() {
		assertEquals(new InvalidScoreException(TennisGameConstants.INVALID_SCORE_POINT), tennisGame.getScoreDesc(4));
	}

	/**
	 * Test case to add points scored by a player to his/her account
	 */
	@Test
	public void testAddScorePointForPointsOfPlayers() {
		tennisGame.addScorePoint(player1); // when point is added one time into player1's account 
		assertEquals(1, player1.getPoints());
		assertEquals(0, player2.getPoints());// when no point has been added to player2's account
	}

	/**
	 * Test case for Player1 as winner
	 */
	@Test
	public void testGetScoreWhenPlayer1Wins() {
		addScore(4,1);
		assertEquals(TennisGameConstants.PLAYER_1_NAME + TennisGameConstants.WON, tennisMatch.getScore());
	}
	
	/**
	 * Test case for Player2 as winner
	 */
	@Test
	public void testGetScoreWhenPlayer2Wins() {
		addScore(1,4);
		assertEquals(TennisGameConstants.PLAYER_2_NAME + TennisGameConstants.WON, tennisMatch.getScore());
	}
	
	/**
	 * Test case for deuce
	 */
	@Test
	public void testGetScoreForDeuce() {
		addScore(3,3);
		assertEquals(TennisGameConstants.PLAYERS_ARE + TennisGameConstants.DEUCE, tennisMatch.getScore());
		addScore(4,4);
		assertEquals(TennisGameConstants.PLAYERS_ARE + TennisGameConstants.DEUCE, tennisMatch.getScore());
	}
	
	/**
	 * Adds score to respective player's bucket in a repeated mode
	 * 
	 * @param player_1_score
	 *            - An int data type
	 * @param player_2_score
	 *            - An int data type
	 */
	void addScore(final int player_1_score, final int player_2_score){
		for (int i=0; i < player_1_score; i++)
			tennisMatch.addScorePoint(player1);
		for (int i=0; i < player_2_score; i++)
			tennisMatch.addScorePoint(player2);
	}
}
