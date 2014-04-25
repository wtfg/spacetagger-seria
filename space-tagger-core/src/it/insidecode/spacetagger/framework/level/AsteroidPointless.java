package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.util.Rectangle;

import com.badlogic.gdx.math.Vector2;

public class AsteroidPointless extends GfxEnemy {

	private static float ENERGY_VALUE = 3;
	private static int SCORE_VALUE = 500;
	private static float DAMAGE_VALUE = 2;
	private static float SPEED_VALUE = .5f;
	
	private Asteroid mainAsteroid;


	public AsteroidPointless(final Framework framework, Vector2 position, Asteroid mAsteroid) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter("asteroid"),
				PropertiesManager.getParameter("explosion"));
		mainAsteroid = mAsteroid;
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if(mainAsteroid.isDestroyed()){
			move(Direction.DOWN);
		}
	}

	@Override
	public boolean intersects(DynamicPhysicsEntity e) {
		if (e instanceof Ship)
			this.body = new Rectangle(0, 0, 0, 0);
		return super.intersects(e);
	}

}