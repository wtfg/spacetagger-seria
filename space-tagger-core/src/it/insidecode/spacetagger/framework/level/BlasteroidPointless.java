package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;

import com.badlogic.gdx.math.Vector2;

/**
 * Un asteroide semplice
 * @author Mauro
 *
 */
public class BlasteroidPointless extends GfxEnemy {

	private static float ENERGY = 3;
	private static int SCORE = 500;
	private static float DAMAGE = 2;
	private static float SPEED = .5f;
	
	private Blasteroid mainAsteroid;
	private static final String fileName = "blasteroid";
	private static final String explosionName = "xplosion";

	/**
	 * Un asteroide che dipende da un asteroide "Master"
	 * @param framework		istanza del framework corrente
	 * @param position		Vector2 con le posizioni
	 * @param mAsteroid		istanza dell'asteroide principale
	 */
	public BlasteroidPointless(final Framework framework, Vector2 position, Blasteroid mAsteroid) {
		super(framework, position, ENERGY, SCORE, DAMAGE,
				SPEED, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter(explosionName));
		mainAsteroid = mAsteroid;
	}

	/**
	 * Computa le mosse dell'asteroide
	 */
	@Override
	public void update(float delta) {
		super.update(delta);
		if(mainAsteroid.isDestroyed()){
			move(Direction.DOWN);
		}
	}

}
