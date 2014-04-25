package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;

import com.badlogic.gdx.math.Vector2;

/**
 * PowerUp che attiva il TripleShot
 * @author Seria.1616892
 *
 */
public class TripleShotPowerUp extends GfxPowerUp {
	
	
	private Framework framework;
	/**
	 * Costruttore di TripleShotPowerUp
	 * 
	 * @param f
	 *            istanza del framework corrente
	 * @param center
	 *            un Vector2 che indica il punto dove deve essere spawnato il
	 *            powerup
	 */
	public TripleShotPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter("tripleShotPowerUp"));
		setCenter(center);
		framework = f;
	}
	
	/**
	 * Applica il nuovo sparo
	 */
	@Override
	public void apply() {
		framework.getShip().setShot(TripleShot.class);
		framework.getShip().setShotDecorator(SmartShotDecorator.class);
	}

}
