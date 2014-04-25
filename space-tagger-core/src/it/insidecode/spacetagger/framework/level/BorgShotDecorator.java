package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.graphics.GameDecorator;
import it.insidecode.spacetagger.shots.Shot;

public class BorgShotDecorator extends ShotDecorator {

	public BorgShotDecorator(GameDecorator gameDecorator, Shot s) {
		super(gameDecorator, s,
				Animation.createAnimation(
				PropertiesManager.getParameter("borgShot"), AnimationType.LOOP),
				Animation.createAnimation(
				PropertiesManager.getParameter("explosion"),
				AnimationType.LOOP));
		
		// TODO Auto-generated constructor stub
	}

}
