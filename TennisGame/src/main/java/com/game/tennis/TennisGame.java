package com.game.tennis;

import com.game.tennis.exception.InvalidScoreException;
import com.game.tennis.util.TennisGameConstants;

/**
 * This class has the business logic related to Tennis Game
 * 
 * @author 2020-DEV-047
 *
 */
public class TennisGame {

	/**
	 * Returns scoreDesc of a player's points{0,1,2,3} These values respectively
	 * correspond to {LOVE,FIFTEEN,THIRTY,FORTY}
	 * 
	 * @param point
	 *            - A int data type
	 * @throws InvalidScoreException 
	 */
	public String getScoreDesc(final int point){
		switch (point) {
		case 0:
			return TennisGameConstants.SCORE_LOVE;
		case 1:
			return TennisGameConstants.SCORE_FIFTEEN;
		case 2:
			return TennisGameConstants.SCORE_THIRTY;
		case 3:
			return TennisGameConstants.SCORE_FORTY;
		default:
				throw new InvalidScoreException(TennisGameConstants.INVALID_SCORE_POINT + point);
		}
	}
}
