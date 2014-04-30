package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Scene06 extends Scene {
	public static final String SCENE_NAME = "Scene 6 - Random Asteroid Generator";

	
	public Scene06(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	/**
	 * Init scena, istanzia i nemici
	 */
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		
		SuperShipPowerUp e = new SuperShipPowerUp(framework, new Vector2(240,650));
		e.activate();
		
		BlasteroidCluster a = new BlasteroidCluster(framework, new Vector2(240,800), 6);
		a.activate();
		
		Nebula3 n = new Nebula3(framework, new Vector2(10,750));
		n.activate();
	
		
		
	}
	

	/**
	 * Immette dei nemici dopo un numero di secondi
	 * Se la navicella muore non c'e il problema del callback
	 * 
	 * @param g	array di nemici da postare
	 * @param delaySeconds	numero di secondi di delay
	 */
	public void postEnemies(final Enemy[] g, int delaySeconds){
		
		countDown(1000*delaySeconds, new SimpleCallback() {
			@Override
			public void onComplete() {
				for(Enemy f : g){
					f.activate();
				}

			}
		});
	}
	
	
	

	@Override
	public void dispose() {
		Gdx.app.log(getName(), "dispose");
	}
	
	

	public void update(float delta) {
		
		if (framework.getGameEngine().getEnemies().isEmpty()){
			getLevel().goToNextScene();
		}

		super.update(delta);
	}

}
