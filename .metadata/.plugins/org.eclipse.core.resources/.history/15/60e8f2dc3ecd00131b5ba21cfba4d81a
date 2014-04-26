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

	private static float ENERGY_VALUE = Constants.ENEMY_A_ENERGY;
	private static int SCORE_VALUE = 1200;
	private static float DAMAGE_VALUE = .1f;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;
	private static String fileName = "enemyBerzerk";

	/**
	 * Costruttore di EnemyBerzerk
	 * 
	 * @param framework
	 *            l'istanza del framework di gioco
	 * @param position
	 *            la posizione con il quale deve essere spawnato
	 */
	public EnemyBerzerk(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter("explosion"));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		// il tempo di sparo e' limitato dal framework, quindi posso sparare ad
		// ogni update
		
		if (isAlive())
			shoot();
	}

}
