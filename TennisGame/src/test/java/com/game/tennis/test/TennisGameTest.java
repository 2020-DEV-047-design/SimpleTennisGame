package com.game.tennis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.game.tennis.TennisGame;
import com.game.tennis.exception.InvalidScoreException;
import com.game.tennis.util.TennisGameConstants;

/**
 * The class is used to check/test the functionalities in TennisGame
 * 
 * @author 2020-DEV-047
 * 
 */

public class TennisGameTest {
	
	TennisGame tennisGame;
	
	@Before
	public void Setup(){
		tennisGame = new TennisGame();
	}
	/**
	 * Test case to get the score description that will be scored by a player
	 * points{0,1,2,3} These values correspond to {LOVE,FIFTEEN,THIRTY,FORTY}
	 */
	@Test
	public void testScoreDescForLove_Fifteen_Thirty_Forty(){		 
		assertEquals(TennisGameConstants.SCORE_LOVE, tennisGame.getScoreDesc(0));
		assertEquals(TennisGameConstants.SCORE_FIFTEEN, tennisGame.getScoreDesc(1));
		assertEquals(TennisGameConstants.SCORE_THIRTY, tennisGame.getScoreDesc(2));
		assertEquals(TennisGameConstants.SCORE_FORTY, tennisGame.getScoreDesc(3));
	}
	
	/**
	 * Test case to check for an exception in case any invalid point is supplied as score
	 * Any value apart from {0,1,2,3} are the invalid points
	 */
	@Test(expected = InvalidScoreException.class)
	public void testScoreDescForValueOtherThan_0_1_2_3_ThrowsException(){
		assertEquals(new InvalidScoreException(TennisGameConstants.INVALID_SCORE_POINT), tennisGame.getScoreDesc(4));
	}
}
