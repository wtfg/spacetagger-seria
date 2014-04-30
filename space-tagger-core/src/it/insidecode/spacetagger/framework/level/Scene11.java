package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Scene11 extends Scene {
	public static final String SCENE_NAME = "Scene 11 - Other bigger enemies";

	
	public Scene11(Framework framework) {
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

		EnemyKamikaze d = new EnemyKamikaze(framework, new Vector2(200,650));
		d.activate();
		
		EnemyClusterSquare e = new EnemyClusterSquare (framework, new Vector2(100,750),50);
		e.setPath(new LinePath(LineDirection.DOWN, 500));
		
		EnemyClusterSquare  f = new EnemyClusterSquare (framework, new Vector2(300,750),50);
		f.setPath(new LinePath(LineDirection.DOWN, 500));
		
		postEnemies(new Enemy[]{ e, f }, 1);
		
		EnemyBig1 b = new EnemyBig1(framework, new Vector2(200,750));
		b.setPath(new LinePath(LineDirection.DOWN, 500));
		
		postEnemies(new Enemy[]{ b }, 2);
		
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
