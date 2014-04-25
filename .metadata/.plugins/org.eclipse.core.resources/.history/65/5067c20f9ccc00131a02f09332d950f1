
package it.insidecode.spacetagger.framework.level;

import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.GameEngine;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Uno shot veloce, nient'altro
 * @author Seria.1616892
 *
 */
public class FastShot extends Shot {
	private static float SHOT_DAMAGE = 3f;
	private static float SHOT_SPEED = 10f;
	
	/**
	 * Damage e Speed sono gia' impostati di suo, altrimenti
	 * non sarebbe fast :)
	 * 
	 * @param gameEngine
	 * 			istanza del GameEngine ricavabile da framework.getGameEngine()
	 * @param v
	 * 			un Vector2 che indica la posizione con il quale va spawnato
	 */
	public FastShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, SHOT_DAMAGE, SHOT_SPEED);
	}

	/**
	 * Questa lista ritorna un singletonList di se' stesso
	 */
	@Override
	public List<Shot> instance() {
		return Collections.singletonList((Shot) this);
	}

}
