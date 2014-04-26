package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.util.Constants;

import com.badlogic.gdx.math.Vector2;

/**
 * Un nemico che si muove secondo la CutterPath
 * 
 * @author Seria.1616892
 * @see it.insidecode.spacetagger.framework.level.CutterPath
 */
public class EnemyCutter extends GfxEnemy {

	private static float ENERGY_VALUE = Constants.ENEMY_A_ENERGY;
	private static int SCORE_VALUE = 1500;
	private static float DAMAGE_VALUE = .5f;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;
	private static String fileName = "enemyCutter";

	/**
	 * Costruttore di EnemyCutter, la path viene settata in automatico a
	 * CutterPath con dei parametri graditi di visibilita
	 * 
	 * @param framework
	 *            istanza corrente del framework
	 * @param position
	 *            elemento Vector2 che indica la posizione del nemico quando
	 *            viene spawnato
	 */
	public EnemyCutter(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter("explosion"));
		setPath(new CutterPath(50, 15, 1000));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
	}

}
