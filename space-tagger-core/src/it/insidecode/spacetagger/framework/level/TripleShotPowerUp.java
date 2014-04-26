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

	private void makeText(){
		GfxText t = new GfxText(framework, "Triple Shot", new SimpleCallback(){
			public void onComplete(){
				Gdx.app.log("TripleShot", "Attivato");
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
