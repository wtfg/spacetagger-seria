package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEntity;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Enemy;

import com.badlogic.gdx.math.Vector2;

public class Shield extends GfxEntity {
	
	private static float ENERGY = 10;
	private static int SCORE = 0;
	private static float DAMAGE = 50;
	private static float SPEED = 0;
	private static final String fileName = "shield";
	private static final String explosionName = "explosion";


	/**
	 * Istanzia uno scudo alla posizione <b>position</b>
	 *  
	 * 
	 * @param framework
	 * @param position
	 */
	public Shield(Framework framework, Vector2 position) {
		super(framework, position, ENERGY, SCORE, DAMAGE, SPEED,
				 PropertiesManager.getParameter(fileName), PropertiesManager.getParameter(explosionName));
		framework.getGameEngine().addCollisionListener(this);
		setCenter(position);
	}

	/**
	 * Gestisce la logica di contatto dello scudo, viene
	 * distrutto se incontra un nemico intermedio che eredita
	 * EnemyIntermediate o se e' istanziata da EnemySnakeHead
	 * o altrimenti distrugge i nemici che incontra
	 * 
	 */
	@Override
	public void handleContact(DynamicPhysicsEntity x){
		super.handleContact(x);
		if(x instanceof Enemy || x instanceof EnemyShot){
			if(x instanceof EnemyIntermediate || x instanceof EnemySnakeHead){
				x.damage(getDamageValue());
				destroy();
			}else{
				x.destroy();
				setEnergy(getEnergy() - x.getDamageValue());	
			}
		}
	}
	
	/**
	 * Aggiorna
	 */
	public void update(float delta){
		super.update(delta);
		if(getEnergy()<=0)
			destroy();
	}

}
