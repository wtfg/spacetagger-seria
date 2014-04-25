package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.shots.SimpleShot;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

/**
 * PowerUp furia, spara a raffica un FuryShot TODO colorare lo schermo di rosso
 * ed implementare blinking TODO impostare la velocita' del tutto
 * 
 * @author Seria.1616892
 * 
 */
public class FuryPowerUp extends GfxPowerUp {

	private static int MAX_SECONDS = 5;
	private Framework framework;

	/**
	 * Crea il powerup
	 * 
	 * @param f
	 *            istanza del framework corrente
	 * @param center
	 *            un Vector2 dove deve essere spawnato il powerup
	 */
	public FuryPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter("tripleShotPowerUp"));
		this.setCenter(center);
		this.framework = f;
	}
	
	/**
	 * Restituisce un Task nel tempo
	 * @return il task specificato
	 */
	private Timer.Task getRunning(){
		return new Timer.Task() {
			@Override
			public void run() {
				framework.getShip().shoot();
			}
		};
	}
	
	/**
	 * Restiuisce il valore di restore
	 * @param framework il framework corrente
	 * @return il task da eseguire
	 */
	private Timer.Task getRestore(final Framework framework, final float sp){
		return new Timer.Task(){
			public void run(){
				framework.getShip().setShot(SimpleShot.class);
				framework.getGameEngine().getBackground().setSpeed(sp);
			}
			
		};
	}

	/**
	 * Effetti di quando il powerup viene applicato
	 */
	@Override
	public void apply() {
		
		// ottiene la navicella e imposta i valori
		final Ship s = framework.getShip();
		s.setShot(FuryShot.class);
		s.setEnergy(s.getMaxEnergy());
		//velocizza
		float sp = framework.getGameEngine().getBackground().getSpeed();
		framework.getGameEngine().getBackground().setSpeed(10f);
		
		// crea un timer e ripete ogni mezzo secondo lo shoot
		// rimuovere limitazione tempo nello shot
		Timer.schedule(getRunning(), 0.5f, 0.5f, 4);
		Timer.schedule(getRestore(framework, sp), MAX_SECONDS);

		
	}

}
