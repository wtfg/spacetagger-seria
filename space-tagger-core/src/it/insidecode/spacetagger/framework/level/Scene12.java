package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Depth;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Scene12 extends Scene {
	public static final String SCENE_NAME = "Scene 11 - Other bigger enemies";

	
	public Scene12(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	
	
	@Override
	public void init() {
		
		ShieldPowerUp s = new ShieldPowerUp(framework, new Vector2(200,650));
		s.activate();
		
		TripleShotPowerUp t = new TripleShotPowerUp(framework, new Vector2(100,850));
		t.activate();
		
		EnergyPowerUp e = new EnergyPowerUp(framework, new Vector2(300,950));
		e.activate();
		
		BossBody b = new BossBody(framework, new Vector2(140,650));
		b.setPath(new LinePath(LineDirection.DOWN, 400));
		b.activate();
		b.setDepth(Depth.ENTITY2);
		
		BossHead h = new BossHead(framework, new Vector2(190,850), b);
		h.setPath(new LinePath(LineDirection.DOWN, 400));
		h.activate();
		h.setDepth(Depth.ENTITY1);
		
		
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
