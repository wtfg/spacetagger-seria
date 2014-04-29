package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;

import com.badlogic.gdx.math.Vector2;

/**
 * Un nemico grappolato, nel costruttore vanno passati i parametri
 * 
 * @author Seria.1616892
 */
public class EnemyCluster extends GfxEnemy {

	private static final float ENERGY = 1;
	private static final int SCORE = 2000;
	private static final float DAMAGE = 4f;
	private static final float SPEED = 2.5f;
	private static final String fileName = "enemyCluster";
	private static final String explosionName = "xplosion";
	private GfxEnemy[] enemyList;

	/**
	 * Costruttore del nemico grappolato, al quale attaccare tutto
	 * 
	 * @param framework
	 *            l'istanza del framework attuale
	 * @param position
	 *            la posizione Vector2 con il quale il nemico va spawnato
	 * @param g
	 *            la lista dei nemici GfxEnemy[] che saranno attaccati al nemico
	 *            in automatico
	 */
	public EnemyCluster(Framework framework, Vector2 position, GfxEnemy[] g) {
		super(framework, position, ENERGY, SCORE, DAMAGE,
				SPEED, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter(explosionName));
		enemyList = g;
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
		
		for (GfxEnemy gf : enemyList) {
			addChildEntity(gf);
			gf.activate();
		}
	}

	/**
	 * Distrugge la nave e quando muore il nemico centrale muoiono tutte le
	 * entita' attaccate a lui
	 */
	@Override
	public void destroy() {
		super.destroy();
		for (GfxEnemy gf : enemyList) {
			gf.destroy();
		}

	}
}
