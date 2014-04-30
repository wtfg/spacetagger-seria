package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.graphics.GameDecorator;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Decora lo Smart Shot
 * @author Mauro
 *
 */
public class SmartShotDecorator extends ShotDecorator {

	private static final String fileName = "smartShot";
	private static final String explosionName = "explosion";
	/**
	 * Costruttore dello ShotDecorator dello SmartShot
	 * 
	 * @param gameDecorator		istanza del gameEngine
	 * @param s					sparo collegato
	 */
	public SmartShotDecorator(GameDecorator gameDecorator, Shot s) {
		super(gameDecorator, s,
				Animation.createAnimation(
				PropertiesManager.getParameter(fileName), AnimationType.LOOP),
				Animation.createAnimation(
				PropertiesManager.getParameter(explosionName),
				AnimationType.LOOP));
	}

}
