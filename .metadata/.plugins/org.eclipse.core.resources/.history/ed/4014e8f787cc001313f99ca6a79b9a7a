package it.insidecode.spacetagger.framework.level;

import java.util.Random;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;

import com.badlogic.gdx.math.Vector2;

/**
 * Un nemico kamikaze, che cerca di andare addosso alla navicella
 * 
 * @author Seria.1616892
 * 
 */
public class EnemyKamikaze extends GfxEnemy {

	private static float ENERGY_VALUE = 2f;
	private static int SCORE_VALUE = 900;
	private static float DAMAGE_VALUE = 3f;
	private static float SPEED_VALUE = 3f;
	private static String fileName = "enemyKamikaze";

	private boolean canShoot;
	private int t;
	private int limit = new Random().nextInt(100);

	/**
	 * Costruttore di EnemyKamikaze, la path viene settata in automatico a
	 * KamikazePath
	 * 
	 * Il nemico EnemyKamikaze non spara di default. Lo sparo puo' essere
	 * attivato con il metodo canShoot(true)
	 * 
	 * @param framework
	 *            istanza corrente del framework
	 * @param position
	 *            elemento Vector2 che indica la posizione del nemico quando
	 *            viene spawnato
	 */
	public EnemyKamikaze(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter("explosion"));
		setPath(new FollowShipPath(framework, this));
		canShoot = false;
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
		
	}

	/**
	 * Imposta la velocita' del nemico
	 * 
	 * @param x
	 *            imposta la velocita' del nemico e della path
	 */
	public void setSpeed(float x) {
		super.setSpeed(x);
		((FollowShipPath) this.getPath()).setSpeed(x);
	}

	/**
	 * Il metodo consente al nemico anche di sparare
	 * 
	 * @param t
	 *            se true, il nemico iniziera' a sparare, se false, il nemico si
	 *            fermera'
	 */
	public void canShoot(boolean t) {
		canShoot = t;
	}

	/**
	 * Il nemico si autodistrugge se incontra la navicella
	 * 
	 * @see it.insidecode.spacetagger.framework.GfxEnemy.handleContact
	 */
	public void handleContact(DynamicPhysicsEntity e) {
		super.handleContact(e);
		if (e instanceof Ship)
			destroy();
	}

	/**
	 * Il nemico spara a random in un tempo casuale di 100 frames
	 * 
	 * @see it.insidecode.spacetagger.framework.GfxEnemy.update
	 */
	public void update(float delta) {
		super.update(delta);
		t++;
		if (t > limit && canShoot) {
			limit = new Random().nextInt(100);
			t = 0;
			if (isAlive())
				shoot();
		}
	}
}
