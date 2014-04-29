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
public class TripleSmartShot extends SmartShot {

	private static float DAMAGE = 0.5f;
	private static final Vector2 shot1Offset = new Vector2(50,30);
	private static final Vector2 shot2Offset = new Vector2(-50,30);

	
	/**
	 * Costruttore del TripleSmartShot
	 * 
	 * @param gameEngine
	 * 			istanza del GameEngine ottenibile tramite framework.getGameEngine()
	 * @param v
	 * 			un Vector2 che indica il punto dove parte lo sparo
	 */
	
	public TripleSmartShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, DAMAGE);
		setWhatToKill(Enemy.class);
		setDirection(Direction.UP);
	}
	
	/**
	 * Restituisce una lista con tre SmartShot
	 * Spostati di 50px in alto e ai lati
	 */
	@Override
	public List<Shot> instance() {
		TripleSmartShot s1 = new TripleSmartShot(gameEngine, this.getPosition().add(shot1Offset));	
		TripleSmartShot s2 = new TripleSmartShot(gameEngine, this.getPosition().add(shot2Offset));
		return Arrays.asList(this, (Shot) s1, (Shot) s2);
	}

}
