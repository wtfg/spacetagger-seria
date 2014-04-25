package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.graphics.GameDecorator;
import it.insidecode.spacetagger.shots.Shot;

public class SmartShotDecorator extends ShotDecorator {

	public SmartShotDecorator(GameDecorator gameDecorator, Shot s) {
		super(gameDecorator, s,
				Animation.createAnimation(
				PropertiesManager.getParameter("smartShot"), AnimationType.LOOP),
				Animation.createAnimation(
				PropertiesManager.getParameter("explosion"),
				AnimationType.LOOP));
		
		// TODO Auto-generated constructor stub
	}

}
