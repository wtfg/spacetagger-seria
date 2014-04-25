package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEntity;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Enemy;

import com.badlogic.gdx.math.Vector2;

public class Shield extends GfxEntity {
	
	private static float ENERGY_VALUE = 10;
	private static int SCORE_VALUE = 0;
	private static float DAMAGE_VALUE = 0;
	private static float SPEED_VALUE = 0;


	public Shield(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE,
				 PropertiesManager.getParameter("shield"), PropertiesManager.getParameter("explosion"));
		framework.getGameEngine().addCollisionListener(this);
		setCenter(position);
	}


	@Override
	public void handleContact(DynamicPhysicsEntity x){
		super.handleContact(x);
		if(x instanceof Enemy || x instanceof EnemyShot){
			x.destroy();	
			setEnergy(getEnergy() - x.getDamageValue());	
		}
	}
	
	public void update(float delta){

		super.update(delta);
		if(getEnergy()<=0)
			destroy();

	}

}
