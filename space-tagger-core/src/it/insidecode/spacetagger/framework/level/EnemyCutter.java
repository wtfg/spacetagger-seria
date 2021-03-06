package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;

import com.badlogic.gdx.math.Vector2;

/**
 * Un nemico che si muove secondo la CutterPath
 * 
 * @author Seria.1616892
 * @see it.insidecode.spacetagger.framework.level.CutterPath
 */
public class EnemyCutter extends GfxEnemy {

	private static final float ENERGY = 1;
	private static final int SCORE = 1500;
	private static final float DAMAGE = .5f;
	private static float SPEED = 2.0f;
	private final CutterPath thePath = new CutterPath(50, 15, 1000);
	private static final String fileName = "enemyCutter";
	private static final String explosionName = "xplosion";

	
	/**
	 * Costruttore di EnemyCutter, la path viene settata in automatico a
	 * CutterPath con dei parametri graditi di visibilita.  Lo spawnaalla
	 * posizione descritta da <i>position</i>, per attivarlo
	 * bisogna chiamare il metodo <b>activate()</b>
	 * 
	 * @param framework
	 *            istanza corrente del framework
	 * @param position
	 *            elemento Vector2 che indica la posizione del nemico quando
	 *            viene spawnato
	 */
	public EnemyCutter(Framework framework, Vector2 position) {
		super(framework, position, ENERGY, SCORE, DAMAGE,
				SPEED, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter(explosionName));
		setPath(thePath);
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
	}

}
