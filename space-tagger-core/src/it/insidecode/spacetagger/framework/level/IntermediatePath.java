package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.Path;

import com.badlogic.gdx.math.Vector2;

/**
 * Path del nemico snake del livello 6
 * @author Seria.1616892
 *
 */
public class IntermediatePath extends Path {

	private Path[] pathsArray;
	private Path currentPath;
	private int current = 0;

	/**
	 * Costruttore della path del serpente intermedio, di raggio
	 * <b>radius</b> dopo essere sceso per una linea dritta di 
	 * altezza <b>y</b>
	 * 
	 * @param radius	raggio cerchio
	 * @param y			y in cui deve scendere
	 */
	public IntermediatePath(int radius, int y) {
		pathsArray = new Path[] { 
				new LinePath(LineDirection.DOWN, y),
				new CircleDownPath(radius, 0)
				};
		currentPath = pathsArray[current];
	}
	
	/**
	 * Aggiorna le path
	 */
	@Override
	public Vector2 getNextPositionIncrement(float speed) {
		if (currentPath.isComplete()) {
			if ((current) >= 1) {
				for (Path x : pathsArray)
					x.reset();
				current = 0;
			}
			currentPath = pathsArray[++current];
		}
		return currentPath.getNextPositionIncrement(speed);
	}

	/**
	 * Implementa i metodi della classe astratta
	 */
	@Override
	public float getX(float speed) {
		return 0;
	}

	@Override
	public float getY(float speed) {
		return 0;
	}

	@Override
	public void reset() {
		current = 0;
	}

	@Override
	public boolean isComplete() {
		return current == pathsArray.length && currentPath.isComplete();
	}

}
