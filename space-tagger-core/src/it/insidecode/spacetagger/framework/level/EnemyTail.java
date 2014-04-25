package it.insidecode.spacetagger.framework.level;

import java.util.Random;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;

import com.badlogic.gdx.math.Vector2;

/**
 * Un nemico banale
 * 
 * @author Seria.1616892
 * 
 */
public class EnemyTail extends EnemySimple {


	private static String fileName = "enemyTail";
	// t e limit servono per aggiornare il tempo di sparo
	private int t;
	private int limit = new Random().nextInt(1500);

	/**
	 * 
	 * @param framework
	 *            istanza del framework corrente
	 * @param position
	 *            un Vector2 che indica la posizione nella quale il nemico va
	 *            spawnato
	 */
	public EnemyTail(Framework framework, Vector2 position, float energy) {
		super(framework, position, energy);
		setAnimation(Animation.createAnimation(PropertiesManager.getParameter(fileName),AnimationType.LOOP));
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
		setShootUpdateTime(1500);
	}

	/**
	 * Comportamento classico, inclusi degli spari in un tempo random ogni 300
	 * frames random
	 */
	@Override
	public void update(float delta) {
		super.update(delta);
		t++;
		if (t > limit) {
			limit = new Random().nextInt(1500);
			t = 0;
			if (isAlive())
				shoot();
		}

	}

}