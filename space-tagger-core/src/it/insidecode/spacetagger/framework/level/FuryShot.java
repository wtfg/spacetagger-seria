package it.insidecode.spacetagger.framework.level;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.GameEngine;

import it.insidecode.spacetagger.shots.Shot;

/**
 * FuryShot e' uno shot che spara tre shot di fila
 * 
 * @author Seria.1616892
 *
 */
public class FuryShot extends Shot {
	
	private static final float DAMAGE = 3f;
	private static final float SPEED = 10f;
	private static final Vector2 delta = new Vector2(0,	60);

	/**
	 * 
	 * @param gameEngine
	 * 			istanza del GameEngine ottenibile con framework.getGameEngine()
	 * @param v
	 * 			punto dal quale parte lo sparo
	 */
	public FuryShot(GameEngine gameEngine, Vector2 v) {
		super(gameEngine, v, DAMAGE, SPEED);
		setDirection(Direction.UP);
		setWhatToKill(Enemy.class);		
	}

	/**
	 * Restituisce delle istanze contenenti tre furyshot nuovi
	 */
	@Override
	public List<Shot> instance() {
		FuryShot s1 = new FuryShot(gameEngine, this.getPosition().add(delta));		
		return Arrays.asList(this, (Shot) s1);
	}

}
