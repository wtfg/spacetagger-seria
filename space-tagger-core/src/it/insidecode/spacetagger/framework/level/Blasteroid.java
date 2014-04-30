package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;

import com.badlogic.gdx.math.Vector2;

/**
 * Un asteroide semplice, senza callback in caso di morte
 * @author Seria.1616892
 *
 */
public class Blasteroid extends GfxEnemy {

	private static float ENERGY = 3;
	private static int SCORE = 500;
	private static float DAMAGE = 2;
	private static float SPEED = 0f;
	
	private static final String fileName = "blasteroid";
	private static final String explosionName = "xplosion";

	
	/**
	 * Costruttore che inizializza l'asteroide alla
	 * posizione descritta da <i>position</i>, per attivarlo
	 * bisogna chiamare il metodo <b>activate()</b>
	 * 
	 * @param framework		istanza del framework corrente
	 * @param position		Vector2 con le posizioni
	 */
	public Blasteroid(final Framework framework, Vector2 position) {
		super(framework, position, ENERGY, SCORE, DAMAGE,
				SPEED, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter(explosionName));
	}
	
	@Override
	public void update(float delta){
		super.update(delta);
		move(Direction.DOWN);
	}

}
