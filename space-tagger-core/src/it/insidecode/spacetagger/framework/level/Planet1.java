package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEntity;
import it.insidecode.spacetagger.logic.Depth;
import it.insidecode.spacetagger.logic.Direction;

import com.badlogic.gdx.math.Vector2;

public class Planet1 extends GfxEntity {

	private static float ENERGY_VALUE = 1;
	private static int SCORE_VALUE = 0;
	private static float DAMAGE_VALUE = 0;
	private static float SPEED_VALUE = .5f;


	public Planet1(final Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter("planet1"),
				PropertiesManager.getParameter("explosion"));
		setDepth(Depth.BACKGROUND1);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		move(Direction.DOWN);
	}
	
}
