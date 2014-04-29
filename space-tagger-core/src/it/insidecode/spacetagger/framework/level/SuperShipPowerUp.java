package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;
import it.insidecode.spacetagger.framework.GfxText;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


/**
 * Un powerup che attiva la SuperShip per 10 secondi
 * 
 * @author Seria.1616892
 * 
 */
public class SuperShipPowerUp extends GfxPowerUp {

	private Framework framework;
	private static String fileName = "superShipPowerUp";
	private static String powerUpName = "Super Ship";
	/**
	 * Costruttore di SmartShotPowerUp
	 * 
	 * @param f
	 *            istanza del framework corrente
	 * @param center
	 *            un Vector2 che indica il punto dove deve essere spawnato il
	 *            powerup
	 */
	public SuperShipPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter(fileName));
		this.setCenter(center);
		this.framework = f;
	}
	
	/**
	 * Applica il testo
	 */
	private void makeText(){
		GfxText t = new GfxText(framework, powerUpName, new SimpleCallback(){
			public void onComplete(){
				Gdx.app.log(powerUpName, "Attivata");
			}
		});
		t.activate();
	}
	/**
	 * Applica il powerUp
	 */
	@Override
	public void apply() {
		makeText();
		//sostituisce con il super sparo
		framework.setShip(new SuperShip(framework, framework.getShip().getPosition()));
		framework.getShip().setShot(TripleSmartShot.class);
	}

}
