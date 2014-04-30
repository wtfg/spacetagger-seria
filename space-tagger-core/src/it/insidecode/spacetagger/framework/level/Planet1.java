package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;

import com.badlogic.gdx.math.Vector2;

/**
 * Un pianeta decorativo
 * @author Seria.1616892
 *
 */
public class Planet1 extends Nebula1 {


	private static final String fileName = "planet1";
		
	/**
	 * Inizializza questa istanza alla posizione <b>position</b>
	 * 
	 * @param framework		istanza del framework corrente
	 * @param position		posizione dove spawnarla
	 */
	public Planet1(final Framework framework, Vector2 position) {
		super(framework, position);
		setAnimation(Animation.createAnimation(PropertiesManager.getParameter(fileName),
				AnimationType.NORMAL));
	}

	
}
