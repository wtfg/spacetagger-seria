package it.insidecode.spacetagger.framework.level;

import java.util.Arrays;
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
public class BossShot extends EnemyShot {

	private static final float DAMAGE_VALUE = 0.2f;


	/**
	 * Costruttore di EnemyShot
	 * 
	 * @param gameEngine
	 *            istanza del GameEngine ottenibile con
	 *            framework.getGameEngine()
	 * @param v
	 *            un Vector2 che contiene la posizione da cui parte lo sparo
	 */
	public BossShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, DAMAGE_VALUE);
	}
	
	/**
	 * Ritorna un singletonList con se' stesso
	 */
	@Override
	public List<Shot> instance() {
		BossShot s1 = new BossShot(gameEngine, getPosition().add(60,0));
		BossShot s2 = new BossShot(gameEngine, getPosition().add(-60,0));
		BossShot s3 = new BossShot(gameEngine, getPosition().add(100,0));
		BossShot s4 = new BossShot(gameEngine, getPosition().add(-100,0));
		return Arrays.asList((Shot) this, (Shot) s1,(Shot) s2, (Shot) s3,(Shot) s4);
	}

}
