package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Scene08 extends Scene {
	public static final String SCENE_NAME = "Scene 8 - Harder Better Faster Stronger";

	
	public Scene08(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");

		EnemySnakeHead head1 = new EnemySnakeHead(framework, new Vector2(380,950), 5);
		head1.setPath(new FollowShipPath(framework, head1));
		head1.setSpeed(3f);
		head1.activate();
		head1.chainEnemies(4);
		
		EnemySnakeHead head2 = new EnemySnakeHead(framework, new Vector2(80,950), 5);
		head2.setPath(new FollowShipPath(framework, head2));
		head2.setSpeed(4f);
		head2.activate();
		head2.chainEnemies(4);
		
		EnemyClusterSquare e = new EnemyClusterSquare(framework, new Vector2(400, 850), 50);
		e.setPath(new DownSlidePath(300, 400, LineDirection.LEFT));
		
		EnemyClusterSquare f = new EnemyClusterSquare(framework, new Vector2(100, 850), 50);
		f.setPath(new DownSlidePath(300, 400, LineDirection.RIGHT));
		
		postEnemies(new Enemy[]{e, f}, 2);
		
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
