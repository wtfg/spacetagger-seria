package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.graphics.GameDecorator;
import it.insidecode.spacetagger.shots.Shot;

/**
 * ShotDecorator del laser Borg
 * @author Mauro
 *
 */
public class BorgLazerShotDecorator extends ShotDecorator {
	private static final String fileName = "borgLazer";
	private static final String explosionName = "explosion";
	
	/**
	 * Costruttore
	 * @param gameDecorator		istanza del gameDecorator
	 * @param s					shot a cui e' collegato
	 */
	public BorgLazerShotDecorator(GameDecorator gameDecorator, Shot s) {
		super(gameDecorator, s,
				Animation.createAnimation(
				PropertiesManager.getParameter(fileName), AnimationType.LOOP),
				Animation.createAnimation(
				PropertiesManager.getParameter(explosionName),
				AnimationType.LOOP));
	}

}
