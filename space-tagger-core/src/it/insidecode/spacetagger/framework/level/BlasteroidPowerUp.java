package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.logic.PowerUp;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.math.Vector2;

/**
 * Un asteroide che rilascia powerup quando viene 
 * distruttto
 * @author Seria.1616892
 *
 */
public class BlasteroidPowerUp extends Blasteroid {

	private static PowerUp p;
	
	private Framework framework;

	/**
	 * Costruttore di un asteroide, inizializza l'oggetto
	 * nella posizione descritta dal costruttore
	 * estende <b>Blasteroid</b> e aggiunge una callback
	 * alla morte
	 * 
	 * @param f				istanza del framework corrente
	 * @param position		posizione asteroide
	 */
	public BlasteroidPowerUp(final Framework f, Vector2 position) {
		super(f, position);

		framework = f;
		this.addOnDeadCallback(new SimpleCallback() {
					@Override
					public void onComplete() {
						p.activate();
					}
				});
	}

	@Override
	public void destroy() {
		p = new ShieldPowerUp(framework, getCenter());
		super.destroy();
	}
}
