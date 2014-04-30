package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.HorizontalHarmonicPath;

import com.badlogic.gdx.math.Vector2;

/**
 * Una path che implementa una HorizontalHarmonicPath che si muove in verticale
 * Path tipica e specifica di EnemyCutter
 * 
 * @author Seria.1616892
 * @see it.insidecode.spacetagger.path.HorizontalHarmonicPath
 */
public class CutterPath extends HorizontalHarmonicPath {

	/** Il campo deltaY implementa la Y della path */
	private float deltaY;
	private float limitHeight;
	private float Y_SPEED = 1.5f;

	/**
	 * Costruttore della path verticale verso il basso specifica per EnemyCutter
	 * Implementta con una HorizontalHarmonicPath che si muove in verticale
	 * Con <b>width</b> si specifica l'ampiezza della path. Con <b>speed</b>
	 * si specifica la velocita' della path e con height la lunghezza della path
	 * 
	 * @param width
	 *            L'ampiezza della path
	 * @param speed
	 *            la velocita' con cui si muove
	 * @param height
	 *            l'altezza con la quale si muove
	 */
	public CutterPath(int width, int speed, int height) {

		super(width, speed);
		deltaY = 0;
		limitHeight = height;
	}

	/**
	 * Imposta la velocita' nella Y della path
	 * 
	 * @param s
	 *            la nuova velocita'
	 */
	public void setSpeed(float s) {
		Y_SPEED = s;
	}

	/**
	 * Metodo che ritorna la velocita' nell'asse Y
	 * 
	 * @return la velocita' nella Y
	 */
	public float getSpeed() {
		return Y_SPEED;
	}

	/**
	 * Ritorna la nuova posizione della Path
	 * Implementata aggiungendo la Y al vettore
	 * 
	 * @return la nuova posizione
	 */
	@Override
	public Vector2 getNextPositionIncrement(float speed) {
		return super.getNextPositionIncrement(speed).sub(0,  Y_SPEED);
	}


	@Override
	public boolean isComplete() {
		return deltaY == limitHeight;
	}

}
