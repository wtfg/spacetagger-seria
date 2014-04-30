package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;
import it.insidecode.spacetagger.framework.GfxText;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * PowerUp che attiva il TripleShot
 * @author Seria.1616892
 *
 */
public class TripleShotPowerUp extends GfxPowerUp {
	
	
	private Framework framework;
	private static final String powerUpName = "Triple Shot";
	private static final String fileName = "tripleShotPowerUp";
	


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
	public TripleShotPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter(fileName));
		setCenter(center);
		framework = f;
	}

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
		framework.getShip().setShot(TripleShot.class);
		framework.getShip().setShotDecorator(SmartShotDecorator.class);
	}

}
