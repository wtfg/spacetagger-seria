package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Scene03 extends Scene {
	public static final String SCENE_NAME = "Scene 0";


	public Scene03(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	@Override
	public void init() {
		Gdx.app.log(getName(), "init");

		SmartShotPowerUp e = new SmartShotPowerUp(framework, new Vector2(240,
				650));
		e.activate();

		EnemySimple a = new EnemySimple(framework, new Vector2(0,50));
		EnemySimple b = new EnemySimple(framework, new Vector2(50,0));
		EnemySimple c = new EnemySimple(framework, new Vector2(-50,0));
		EnemyCluster d = new EnemyCluster(framework, new Vector2(200,650), new GfxEnemy[]{
			a, b, c
		});
		d.setPath(new LinePath(LineDirection.DOWN,700));
		d.activate();
		

		EnemyClusterSquare f = new EnemyClusterSquare(framework, new Vector2(
				300, 750), 50);
		f.setPath(new CircleDownPath(60, 2));
		EnemyClusterSquare g = new EnemyClusterSquare(framework, new Vector2(
				100, 750), 50);
		g.setPath(new CircleDownPath(60, 2));

		postEnemies(new Enemy[] { f, g }, 1);
		
	
		Nebula1 n = new Nebula1(framework, new Vector2(-260,750));
		n.activate();
		
	}

	/**
	 * Immette dei nemici dopo un numero di secondi Se la navicella muore non
	 * c'e il problema del callback
	 * 
	 * @param g
	 *            array di nemici da postare
	 * @param delaySeconds
	 *            numero di secondi di delay
	 */
	public void postEnemies(final Enemy[] g, int delaySeconds) {

		countDown(1000 * delaySeconds, new SimpleCallback() {
			@Override
			public void onComplete() {
				for (Enemy f : g) {
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

		if (framework.getGameEngine().getEnemies().isEmpty()) {
			getLevel().goToNextScene();
		}

		super.update(delta);
	}

}
