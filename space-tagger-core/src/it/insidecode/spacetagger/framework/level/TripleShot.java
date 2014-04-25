package it.insidecode.spacetagger.framework.level;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.logic.GameEngine;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Sparo triplo!
 * Inizialmente e' dei buoni, uccide i nemici
 * @author Seria.1616892
 *
 */
public class TripleShot extends Shot {

	/**
	 * Costruttore del TripleShot
	 * 
	 * @param gameEngine
	 * 			istanza del GameEngine ottenibile tramite framework.getGameEngine()
	 * @param v
	 * 			un Vector2 che indica il punto dove parte lo sparo
	 */

	private static float DAMAGE_VALUE = 1f;
	private static float SPEED_VALUE = 6f;
	
	public TripleShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, DAMAGE_VALUE, SPEED_VALUE);
		setWhatToKill(Enemy.class);
		setDirection(Direction.UP);
	}
	
	/**
	 * Restituisce una lista con tre TripleShot
	 * Spostati di 50px in alto e ai lati
	 */
	@Override
	public List<Shot> instance() {
		TripleShot s1 = new TripleShot(gameEngine, this.getPosition().add(50,
				50));	
		TripleShot s2 = new TripleShot(gameEngine, this.getPosition().add(-50,
				50));
		return Arrays.asList(this, (Shot) s1, (Shot) s2);
	}

}
