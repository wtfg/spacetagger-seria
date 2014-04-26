package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.logic.PowerUp;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.math.Vector2;

public class Blasteroid extends GfxEnemy {

	private static final float ENERGY = 3;
	private static final int SCORE = 500;
	private static final float DAMAGE = 1;
	private static final float SPEED = .5f;

	private static boolean isDestroyed = false;
	private static PowerUp p;

	private Framework framework;

	public Blasteroid(final Framework f, Vector2 position) {
		super(f, position, ENERGY, SCORE, DAMAGE,
				SPEED, PropertiesManager.getParameter("blasteroid"),
				PropertiesManager.getParameter("xplosion"),
				new SimpleCallback() {
					@Override
					public void onComplete() {
						p.activate();
						isDestroyed = true;
					}
				});
		framework = f;

	}

	@Override
	public void update(float delta) {
		super.update(delta);
		move(Direction.DOWN);
	}
	
	public boolean isDestroyed(){
		return isDestroyed;
	}

	@Override
	public void destroy() {
		p = new ShieldPowerUp(framework, getCenter());
		super.destroy();
	}

	public void handleContact(DynamicPhysicsEntity x){
		if(x instanceof Ship)
			x.destroy();
		if(x instanceof Shot){
			damage(x.getDamageValue());
			x.destroy();
		}
	}

}
