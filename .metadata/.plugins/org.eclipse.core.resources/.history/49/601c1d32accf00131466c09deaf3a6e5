package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;

import com.badlogic.gdx.math.Vector2;

/**
 * La coda del serpentone
 * 
 * @author Seria.1616892
 * 
 */
public class EnemySnakeTail extends EnemySimple {


	private static final String fileName = "enemyTail";
	private static final int SHOOT_TIME = 1500;
	/**
	 * 
	 * @param framework
	 *            istanza del framework corrente
	 * @param position
	 *            un Vector2 che indica la posizione nella quale il nemico va
	 *            spawnato
	 * @param energy
	 * 			  energia del nemico
	 */
	public EnemySnakeTail(Framework framework, Vector2 position, float energy) {
		super(framework, position, energy);
		setAnimation(Animation.createAnimation(PropertiesManager.getParameter(fileName),AnimationType.LOOP));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
		setShootUpdateTime(SHOOT_TIME);
	}


}
