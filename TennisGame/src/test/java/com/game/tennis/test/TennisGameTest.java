package com.game.tennis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.game.tennis.TennisGame;
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
	public void testScoreDescForLove_Fifteen() {		 
		assertEquals(TennisGameConstants.SCORE_LOVE, tennisGame.getScoreDesc(0));
		assertEquals(TennisGameConstants.SCORE_FIFTEEN, tennisGame.getScoreDesc(1));
	}
}
