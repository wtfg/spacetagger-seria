package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.util.Constants;

import com.badlogic.gdx.math.Vector2;


/**
 * Un nemico che spara a raffica
 * 
 * @author Seria.1616892
 * @see it.insidecode.spacetagger.framework.GfxEnemy
 */
public class EnemyBerzerk extends GfxEnemy {

	private static final float ENERGY = Constants.ENEMY_A_ENERGY;
	private static final int SCORE = 1200;
	private static final float DAMAGE = .1f;
	private static final float SPEED = Constants.ENEMY_A_SPEED;
	private static final String fileName = "enemyBerzerk";
	private static final String explosionName = "xplosion";

	
	/**
	 * Costruttore di EnemyBerzerk
	 * 
	 * @param framework
	 *            l'istanza del framework di gioco
	 * @param position
	 *            la posizione con il quale deve essere spawnato
	 */
	public EnemyBerzerk(Framework framework, Vector2 position) {
		super(framework, position, ENERGY, SCORE, DAMAGE,
				SPEED, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter(explosionName));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		// il tempo di sparo e' limitato dalla costante di default, quindi posso sparare ad
		// ogni update
		if (isAlive())
			shoot();
	}

}
