package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.framework.GfxShip;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;

public class SuperShip extends GfxShip {

	
	public SuperShip(Framework framework, Vector2 pos) {
		super(framework, pos, Animation.createAnimation(PropertiesManager.getParameter("superIdle"), AnimationType.NORMAL), 
				 Animation.createAnimation(PropertiesManager.getParameter("superFromLeft"), AnimationType.NORMAL),
				 Animation.createAnimation(PropertiesManager.getParameter("superFromRight"), AnimationType.NORMAL),
				 Animation.createAnimation(PropertiesManager.getParameter("superLeft"), AnimationType.NORMAL),
				 Animation.createAnimation(PropertiesManager.getParameter("superRight"), AnimationType.NORMAL),
				 Animation.createAnimation(PropertiesManager.getParameter("explosion"), AnimationType.NORMAL));
		setShot(TripleShot.class);
		increaseSpeed(1f);
	}


	public void handleContact(DynamicPhysicsEntity x){
		super.handleContact(x);
		if(x instanceof GfxEnemy){
			float theDamage = x.getDamageValue();
			setEnergy(getEnergy() + theDamage*2/3);
		}
		
	}

}
