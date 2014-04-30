package it.insidecode.spacetagger.framework.level;


import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.GameEngine;

/**
 * Shot laser del nemico
 * 
 * @author Seria.1616892
 * 
 */
public class EnemyLazerShot extends EnemyShot {

	private static final float DAMAGE = 1f;
	private static final float SPEED = 8f;
	/**
	 * Costruttore di EnemyLazerShot 
	 * 
	 * @param gameEngine
	 *            istanza del GameEngine ottenibile con
	 *            framework.getGameEngine()
	 * @param v
	 *            un Vector2 che contiene la posizione da cui parte lo sparo
	 */
	public EnemyLazerShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, DAMAGE);
		setSpeed(SPEED);
		
	}


}
