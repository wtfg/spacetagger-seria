package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;
import it.insidecode.spacetagger.framework.GfxText;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

/**
 * PowerUp furia, spara a raffica un FuryShot 
 * 
 * @author Seria.1616892
 * 
 */
public class FuryPowerUp extends GfxPowerUp {

	private static int MAX_SECONDS = 10;
	private Framework framework;
	private static String fileName = "furyPowerUp";
	/**
	 * Crea il powerup
	 * 
	 * @param f
	 *            istanza del framework corrente
	 * @param center
	 *            un Vector2 dove deve essere spawnato il powerup
	 */
	public FuryPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter(fileName));
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
				framework.getShip().setEnergy(framework.getShip().getMaxEnergy());
			}
		};
	}
	
	/**
	 * Restiuisce il valore di restore
	 * @param framework il framework corrente
	 * @return il task da eseguire
	 */
	private Timer.Task getRestore(final Framework framework, final float sp, final int old){
		return new Timer.Task(){
			public void run(){
				framework.getShip().setShot(SimpleShot.class);
				framework.getGameEngine().getBackground().setSpeed(sp);
				framework.getShip().setShotDelay(old);
				framework.getShip().setEnergy(10);
			}
			
		};
	}

	private void makeText(){
		GfxText t = new GfxText(framework, "FURY!", new SimpleCallback(){
			public void onComplete(){
				Gdx.app.log("Fury", "Attivato");
			}
		});
		t.activate();
	}
	
	/**
	 * Effetti di quando il powerup viene applicato
	 */
	@Override
	public void apply() {
		makeText();
		// ottiene la navicella e imposta i valori
		Ship s = framework.getShip();
		
		float oldBackgroundSpeed = framework.getGameEngine().getBackground().getSpeed();
		int oldShotDelay = s.getShotDelay();
		
		s.setShot(FuryShot.class);
		s.setShotDelay(10);
		

		//velocizza
		
		framework.getGameEngine().getBackground().setSpeed(10f);
		
		// crea un timer e ripete ogni mezzo secondo lo shoot
		// rimuovere limitazione tempo nello shot
		Timer.schedule(getRunning(), 0.1f, 0.1f, (int) MAX_SECONDS*10);
		Timer.schedule(getRestore(framework, oldBackgroundSpeed, oldShotDelay), MAX_SECONDS);
		
	}

}
