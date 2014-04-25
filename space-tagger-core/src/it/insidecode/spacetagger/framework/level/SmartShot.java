package it.insidecode.spacetagger.framework.level;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.logic.GameEngine;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Sparo intelligente che perseguita il primo nemico che incontra
 * @author Seria.1616892
 *
 */
public class SmartShot extends Shot {

	private float addedX;
	private Collection<?> linkedEnemies;
	private static float ADJUST_VALUE = 0.4f;
	private static float DAMAGE_VALUE = 3f;
	private static float SPEED_VALUE  = 6f;
	
	/**
	 * Costruttore dello SmartShot
	 * @param gameEngine
	 * 			istanza del GameEngine ottenibile con framework.getGameEngine()
	 * @param v
	 * 			un Vector2 che contiene la posizione da cui parte lo sparo
	 */
	public SmartShot(GameEngine gameEngine, Vector2 v) {
		// chiamata a supercostruttore
		super(gameEngine, v, DAMAGE_VALUE, SPEED_VALUE);
		//setDirection(Direction.UP);
		setWhatToKill(Enemy.class);
		// ottiene i nemici
		linkedEnemies = gameEngine.getListeningEnemies();
		
		
	}
	/**
	 * Costruttore Overload dello SmartShot
	 * @param gameEngine
	 * 			istanza del GameEngine ottenibile con framework.getGameEngine()
	 * @param v
	 * 			un Vector2 che contiene la posizione da cui parte lo sparo
	 */
	public SmartShot(GameEngine gameEngine, Vector2 v, float damage) {
		// chiamata a supercostruttore
		super(gameEngine, v, damage, SPEED_VALUE);
		//setDirection(Direction.UP);
		setWhatToKill(Enemy.class);
		// ottiene i nemici
		linkedEnemies = gameEngine.getListeningEnemies();
		
		
	}
	
	/**
	 * Ottiene il primo nemico che ha davanti
	 * @return
	 * 			Una entity col primo nemico presente
	 */
	public Enemy getFirstEnemy(){
		return ((Enemy) linkedEnemies.toArray()[0]);
	}
	
	/**
	 * Ottiene il deltaY della nave rispetto ad un vettore.
	 * @param v
	 * 			il vettore della posizione
	 * @return
	 * 			il delta effettivo (anche negativo)
	 */
	private float getDeltaFromShip(Vector2 v){
		return v.y - gameEngine.getShip().getPosition().y;
	}
	
	/**
	 * Ottiene il deltaX dello sparo rispetto ad un vettore
	 * @param v
	 * 			il vettore della posizione
	 * @return
	 * 			il delta effettivo (anche negativo)
	 */
	private float getDeltaX(Vector2 v){
		return v.x - getPosition().x;
	}
	
	/**
	 * Confronta il delta e aggiunge al vettore di supporto per correggere il tiro
	 * @param deltaX
	 * 			il deltaX considerato
	 */
	private void adjustDelta(float deltaX){
		if(deltaX>5)
			addedX += ADJUST_VALUE;
		else if (deltaX<-5)
			addedX -= ADJUST_VALUE;
	}
	
	@Override
	public void update(float f){
		super.update(f);
		//controlla se i nemici ci sono
		if(linkedEnemies.toArray().length > 0){
			// posizione nemico
			Vector2 enemyPos = getFirstEnemy().getPosition();
			
			// se il nemico e' troppo vicino
			if (getDeltaFromShip(enemyPos) - 100 < 0){
				// cambia obiettivo
				linkedEnemies.remove(getFirstEnemy());
				update(f);
			}else{
				// altrimenti vai in cerca del marrano
				adjustDelta(getDeltaX(enemyPos));			
				this.setPosition( this.getPosition().add(addedX,0));
			}
		}
		
	}

	@Override
	public List<Shot> instance() {
		return Collections.singletonList((Shot)this);
	}

}
