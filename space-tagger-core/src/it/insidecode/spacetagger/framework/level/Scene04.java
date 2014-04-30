package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Scene04 extends Scene {
	public static final String SCENE_NAME = "Scene 4 - Composite Enmies & TripleShot";

	
	public Scene04(Framework framework) {
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
		
		TripleShotPowerUp e = new TripleShotPowerUp(framework, new Vector2(240,1050));
		e.activate();
		
		EnemyBerzerk g = new EnemyBerzerk(framework, new Vector2(50,650));
		g.setPath(new DownSlidePath(250,400, LineDirection.RIGHT));
		EnemyBerzerk h = new EnemyBerzerk(framework, new Vector2(350,750));
		h.setPath(new DownSlidePath(250,400, LineDirection.LEFT));

		g.activate();
		h.activate();
		
		EnemyClusterSquare a = new EnemyClusterSquare(framework, new Vector2(100,950), 50);
		a.setPath(new LinePath(LineDirection.DOWN, 400));
		EnemyClusterSquare b = new EnemyClusterSquare(framework, new Vector2(300,950), 50);
		b.setPath(new LinePath(LineDirection.DOWN, 400));
		
		postEnemies(new Enemy[]{a, b}, 1);
		
		Planet1 p = new Planet1(framework, new Vector2(200,750));
		p.activate();
		
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
