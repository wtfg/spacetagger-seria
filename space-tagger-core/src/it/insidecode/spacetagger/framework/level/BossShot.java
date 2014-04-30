package it.insidecode.spacetagger.framework.level;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.GameEngine;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Shot quintuplo del boss
 * 
 * @author Seria.1616892
 * 
 */
public class BossShot extends EnemyShot {

	private static final float DAMAGE = 0.5f;
	private static final int delta1 = 60;
	private static final int delta2 = 100;

	/**
	 * Costruttore di BossShot, inizializza lo sparo
	 * nella posizione <b>v</b> e viene inizializzato
	 * tramite Reflection
	 * 
	 * @param gameEngine
	 *            istanza del GameEngine ottenibile con
	 *            framework.getGameEngine()
	 * @param v
	 *            un Vector2 che contiene la posizione da cui parte lo sparo
	 */
	public BossShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, DAMAGE);
	}
	
	/**
	 * Ritorna una lista di 5 spari 
	 */
	@Override
	public List<Shot> instance() {
		BossShot s1 = new BossShot(gameEngine, getPosition().add(delta1,0));
		BossShot s2 = new BossShot(gameEngine, getPosition().add(-delta1,0));
		BossShot s3 = new BossShot(gameEngine, getPosition().add(delta2,0));
		BossShot s4 = new BossShot(gameEngine, getPosition().add(-delta2,0));
		return Arrays.asList((Shot) this, (Shot) s1,(Shot) s2, (Shot) s3,(Shot) s4);
	}

}
