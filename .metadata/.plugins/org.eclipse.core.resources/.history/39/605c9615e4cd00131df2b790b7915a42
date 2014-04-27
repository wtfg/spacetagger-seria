package it.insidecode.spacetagger.framework.level;

import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.GameEngine;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Shot indebolito del nemico
 * 
 * @author Seria.1616892
 * 
 */
public class EnemyShot extends Shot {

	private static final float DAMAGE_VALUE = 0.5f;
	private static final float SPEED_VALUE = 4.5f;

	/**
	 * Costruttore di EnemyShot
	 * 
	 * @param gameEngine
	 *            istanza del GameEngine ottenibile con
	 *            framework.getGameEngine()
	 * @param v
	 *            un Vector2 che contiene la posizione da cui parte lo sparo
	 */
	public EnemyShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, DAMAGE_VALUE, SPEED_VALUE);
	}
	/**
	 * Costruttore di EnemyShot
	 * 
	 * @param gameEngine
	 *            istanza del GameEngine ottenibile con
	 *            framework.getGameEngine()
	 * @param v
	 *            un Vector2 che contiene la posizione da cui parte lo sparo
	 * @param damage
	 *            danno dello sparo
	 */
	public EnemyShot(GameEngine gameEngine, Vector2 v, float damage) {
		super(gameEngine, v, damage, SPEED_VALUE);
	}
	/**
	 * Ritorna un singletonList con se' stesso
	 */
	@Override
	public List<Shot> instance() {
		return Collections.singletonList((Shot) this);
	}

}
