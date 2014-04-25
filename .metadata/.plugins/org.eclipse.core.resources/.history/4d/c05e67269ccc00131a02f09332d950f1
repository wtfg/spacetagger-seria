package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;


/**
 * Path che segue la navicella, implementata con un vettore deltaX che indica lo
 * spostamento Implementata con un'estensione di LinePath a cui modifica la X in
 * base al centro della navicella
 * 
 * @author Seria.1616892
 * 
 */
public class FollowShipPath extends LinePath {

	private float addedX;
	private Framework framework;
	private float SPEED_VALUE = 1f;
	private Enemy enemy;

	/**
	 * La path che segue la navicella. Siccome deve seguire la navicella non
	 * servono altri parametri
	 * 
	 * @param f
	 *            istanza del framework corrente
	 */
	public FollowShipPath(Framework f, Enemy e) {
		super(LineDirection.DOWN, 1000);
		this.enemy = e;
		framework = f;
	}

	/**
	 * Setta la velocita' nella X con la quale il nemico deve correre appresso
	 * alla navicella
	 * 
	 * @param f
	 *            la velocita' (di default e' 1f)
	 */
	public void setSpeed(float f) {
		SPEED_VALUE = f;
	}

	/**
	 * Implementa la posizione della Path tenendo conto della posizione della
	 * navicella
	 */
	@Override
	public Vector2 getNextPositionIncrement(float speed) {
		
		// evita errori se il nemico non viene istanziato
		if (enemy == null){
			
			return super.getNextPositionIncrement(speed);
		}
		// ottiene il deltaX sottraendo il proprio centro con quello della
		// navicella
		float deltaX = enemy.getCenter().x
				- framework.getGameEngine().getShip().getCenter().x;
		
		if (deltaX < -10)
			addedX = SPEED_VALUE;
		else if (deltaX > 10)
			addedX = -SPEED_VALUE;
		else
			addedX = 0;
		
		return super.getNextPositionIncrement(speed).add(addedX,0);
		
		// aggiunge alla X il valore dX
		//return super.getNextPositionIncrement(speed).add(addedX, 0);
	}

}
