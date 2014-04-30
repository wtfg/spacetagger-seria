package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;
import it.insidecode.spacetagger.framework.GfxText;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Un powerup che attiva lo SmartShot
 * 
 * @author Seria.1616892
 * 
 */
public class SmartShotPowerUp extends GfxPowerUp {

	private Framework framework;
	private static final String fileName = "smartShotPowerUp";
	private static final String powerUpName = "Smart Shot";
	
	
	/**
	 * Inizializza il powerUp alla posizione descritta da 
	 * <i>center</i>, per attivarlo  bisogna chiamare il metodo
	 * <b>activate()</b>
	 * 
	 * @param f
	 *            istanza del framework corrente
	 * @param center
	 *            un Vector2 dove deve essere spawnato il powerup
	 */
	public SmartShotPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter(fileName));
		this.setCenter(center);
		framework = f;
	}

	/**
	 * Fa apparire il testo
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
	 * Applica il nuovo sparo
	 */
	@Override
	public void apply() {
		makeText();
		//sostituisce con il super sparo
		framework.getShip().setShot(SmartShot.class);
		framework.getShip().setShotDecorator(SmartShotDecorator.class);

	}

}
