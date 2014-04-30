package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Scene09 extends Scene {
	public static final String SCENE_NAME = "Scene 9 - Fast N Furious";

	
	public Scene09(Framework framework) {
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
		
		EnemySnakeHead head1 = new EnemySnakeHead(framework, new Vector2(200,750), 5);
		head1.setPath(new IntermediatePath(100,500));
		head1.setSpeed(2f);
		head1.activate();
		head1.chainEnemies(10);
		
		for(int i=0; i<=4; i++){
			for(int j=0; j<=7; j++){
				EnemySimple e = new EnemySimple(framework, new Vector2(50+80*i,650+j*80));
				e.setPath(new LinePath(LineDirection.DOWN, 1500));
				e.activate();
			}
		}
		
		
		
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
