package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;

import com.badlogic.gdx.math.Vector2;

public class Nebula3 extends Nebula1 {

	private static final String fileName = "nebula3";

	public Nebula3(final Framework framework, Vector2 position) {
		super(framework, position);
		setAnimation(Animation.createAnimation(PropertiesManager.getParameter(fileName), AnimationType.NORMAL));
	}
	
}
