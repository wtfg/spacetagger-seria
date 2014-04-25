package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;
import it.insidecode.spacetagger.shots.SimpleShot;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

/**
 * Un powerup che attiva lo SmartShot per 10 secondi
 * 
 * @author Seria.1616892
 * 
 */
public class SmartShotPowerUp extends GfxPowerUp {

	private Framework framework;
	private static int EFFECT_TIME = 10;

	/**
	 * Costruttore di SmartShotPowerUp
	 * 
	 * @param f
	 *            istanza del framework corrente
	 * @param center
	 *            un Vector2 che indica il punto dove deve essere spawnato il
	 *            powerup
	 */
	public SmartShotPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter("SmartShotPowerUp"));
		this.setCenter(center);
		this.framework = f;
	}
	
	/**
	 * Ritorna il task eseguibile dopo aver completato l'effetto
	 * @param framework il framework corrente
	 * @return il task specificato per il restore
	 */
	
	private Timer.Task getRestore(final Framework framework){
		return new Timer.Task(){
			@Override
			public void run(){
				framework.getShip().setShot(SimpleShot.class);
			}
		};
	}

	/**
	 * Applica il nuovo sparo
	 */
	@Override
	public void apply() {

		//sostituisce con il super sparo
		framework.getShip().setShot(SmartShot.class);
		framework.getShip().setShotDecorator(SmartShotDecorator.class);
		//crea un GameTimer che dopo 10 secondi ritorna a prima
		Timer.schedule(getRestore(framework), EFFECT_TIME);
	}

}