package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;

import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Scene02 extends Scene {
	public static final String SCENE_NAME = "Scene 2";

	
	public Scene02(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		
	
		
		EnemyKamikaze f = new EnemyKamikaze(framework, new Vector2(50,750));
		EnemyKamikaze g = new EnemyKamikaze(framework, new Vector2(200,650));
		g.setSpeed(2f);
		EnemyKamikaze h = new EnemyKamikaze(framework, new Vector2(350,850));
		
		f.activate();
		g.activate();
		h.activate();
		
		EnemyCutter a = new EnemyCutter(framework, new Vector2(150,750));
		EnemyCutter b = new EnemyCutter(framework, new Vector2(250,850));
		EnemyCutter c = new EnemyCutter(framework, new Vector2(350,750));
		
		postEnemies(new Enemy[]{a, b, c}, 1);
		
		EnemySimple x = new EnemySimple(framework, new Vector2(100,650));
		x.setPath(new DownSlidePath(200,300,LineDirection.RIGHT));
		EnemySimple y = new EnemySimple(framework, new Vector2(300,650));
		y.setPath(new DownSlidePath(200,200,LineDirection.LEFT));
		EnemySimple z = new EnemySimple(framework, new Vector2(200,750));
		z.setPath(new FollowShipPath(framework, x));
		
		postEnemies(new Enemy[]{x, y, z}, 2);

		
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
