package it.insidecode.spacetagger.framework.level;

import java.util.Random;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;


import com.badlogic.gdx.math.Vector2;

/**
 * Un nemico banale
 * 
 * @author Seria.1616892
 * 
 */
public class EnemySimple extends GfxEnemy {

	/**
	 * Costanti
	 */
	private static final float ENERGY_VALUE = 1;
	private static final int SCORE_VALUE = 500;
	private static final float DAMAGE_VALUE = 1f;
	private static final float SPEED_VALUE = 2f;
	private static final String fileName = "enemySimple";
	private static final String explosionName = "xplosion";
	
	private int SHOOT_UPDATE_TIME = 300;
	// t e limit servono per aggiornare il tempo di sparo
	private int t;
	private int limit = new Random().nextInt(SHOOT_UPDATE_TIME);

	/**
	 * Un nemico semplice spawnato alla
	 * posizione descritta da <i>position</i>, per attivarlo
	 * bisogna chiamare il metodo <b>activate()</b> 
	 * 
	 * @param framework
	 *            istanza del framework corrente
	 * @param position
	 *            un Vector2 che indica la posizione nella quale il nemico va
	 *            spawnato
	 */
	public EnemySimple(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter(explosionName));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
	}
	
	/**
	 * 
	 * @param framework
	 *            istanza del framework corrente
	 * @param position
	 *            un Vector2 che indica la posizione nella quale il nemico va
	 *            spawnato
	 * @param energy
	 * 				energia del nemico
	 */
	public EnemySimple(Framework framework, Vector2 position, float energy) {
		super(framework, position, energy, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter("explosion"));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
	}
	/**
	 * 
	 * @param framework
	 *            istanza del framework corrente
	 * @param position
	 *            un Vector2 che indica la posizione nella quale il nemico va
	 *            spawnato
	 * @param energy
	 * 				energia del nemico
	 */
	public EnemySimple(Framework framework, Vector2 position, float energy, int score) {
		super(framework, position, energy, score, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter("explosion"));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
	}
	/**
	 * Comportamento classico, inclusi degli spari in un tempo random ogni 300
	 * frames random
	 */
	@Override
	public void update(float delta) {
		super.update(delta);
		t++;
		if (t > limit) {
			limit = new Random().nextInt(SHOOT_UPDATE_TIME);
			t = 0;
			if (isAlive())
				shoot();
		}

	}
	/**
	 * Imposta un range di lontananza per lo sparo
	 * @param time
	 */
	protected void setShootUpdateTime(int time){
		SHOOT_UPDATE_TIME = time;
	}
}
