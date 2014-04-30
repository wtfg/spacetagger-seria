package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.graphics.GameDecorator;
import it.insidecode.spacetagger.shots.Shot;

/**
 * ShotDecoraor dello sparo dei nemici
 * @author Seria.1616892
 *
 */
public class BorgShotDecorator extends ShotDecorator {

	private static final String fileName = "borgShot";
	private static final String explosionName = "explosion";
	
	/**
	 * Inizializza il decoratore con l'animazione, presente
	 * nei campi della classe. Il gioco lo inizializza tramite
	 * reflection.
	 * 
	 * @param gameDecorator		istanza del gameDecorator
	 * @param s					shot a cui e' collegato
	 */
	public BorgShotDecorator(GameDecorator gameDecorator, Shot s) {
		super(gameDecorator, s,
				Animation.createAnimation(
				PropertiesManager.getParameter(fileName), AnimationType.LOOP),
				Animation.createAnimation(
				PropertiesManager.getParameter(explosionName),
				AnimationType.LOOP));
	}

}
