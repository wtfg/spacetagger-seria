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

	private final int MAX_SECONDS = 10;
	private static final int SHOOT_DELAY = 10;
	private static final float shootRate = 0.1f;
	private static final float BG_SPEED = 10f;
	private Framework framework;
	private static String fileName = "furyPowerUp";
	private static final String powerUpName = "FURY!";
	
	/**
	 * Inizializza il powerUp furia per il tempo <b>MAX_SECONDS</b> alla
	 * posizione descritta da <i>center</i>, per attivarlo 
	 * bisogna chiamare il metodo <b>activate()</b>
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
	private Timer.Task getRunningTask(){
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
	private Timer.Task getRestoreTask(final Framework framework, final float sp, final int old){
		return new Timer.Task() {
			@Override
			public void run() {
				framework.getShip().setShot(SimpleShot.class);
				framework.getGameEngine().getBackground().setSpeed(sp);
				framework.getShip().setShotDelay(old);
				framework.getShip().setEnergy(10);
			}
			
		};
	}

	/**
	 * Inserisce il testo
	 */
	private void makeText(){
		GfxText t = new GfxText(framework, powerUpName, new SimpleCallback(){
			public void onComplete(){
				Gdx.app.log(powerUpName, "Attivato");
			}
		});
		t.activate();
	}
	
	/**
	 * Quando il powerup viene applicato setta un
	 * timeout per ristabilire il tutto
	 */
	@Override
	public void apply() {
		
		makeText();
		// ottiene la navicella e imposta i valori
		Ship s = framework.getShip();

		float oldBackgroundSpeed = framework.getGameEngine().getBackground().getSpeed();
		int oldShotDelay = s.getShotDelay();
		
		s.setShot(FuryShot.class);
		s.setShotDelay(SHOOT_DELAY);
		
		framework.getGameEngine().getBackground().setSpeed(BG_SPEED); //velocizza		
		
		// crea un timer ripetuto e innesca la disattivazione
		Timer.schedule(getRunningTask(), shootRate, shootRate, (int) MAX_SECONDS * SHOOT_DELAY);
		Timer.schedule(getRestoreTask(framework, oldBackgroundSpeed, oldShotDelay), MAX_SECONDS);
		
	}

}
