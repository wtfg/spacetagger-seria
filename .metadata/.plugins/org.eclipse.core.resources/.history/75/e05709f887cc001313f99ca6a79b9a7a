package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Scene07 extends Scene {
	public static final String SCENE_NAME = "Scene 0";
	private Enemy head;
	
	public Scene07(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		
		framework.setStageMusic(PropertiesManager.getParameter("stage1"));

		head = new EnemyHead(framework, new Vector2(350,650), 20);
		head.setPath(new IntermediatePath(300,300));
		head.setSpeed(3f);
		head.activate();
		chainEnemies(15, head);
		/*Enemy old = head;
		for(int i = 0; i < 15; i++){
			EnemyTail e = new EnemyTail(framework, new Vector2(200,650+i*60), 10-i);
			e.setPath(new ChainPath(old, e));
			e.activate();
			old = e;
		}*/
	}
	
	private void chainEnemies(int enemyNum, Enemy firstEnemy){
		Enemy old = firstEnemy;
		for(int i = 0; i < enemyNum; i++){
			EnemyTail e = new EnemyTail(framework, new Vector2(200,650+i*60), head.getEnergy()-i);
			e.setPath(new ChainPath(old, e));
			e.activate();
			old = e;
		}
	}


	@Override
	public void dispose() {
		Gdx.app.log(getName(), "dispose");
	}
	
	

	public void update(float delta) {
		
		if (!head.isAlive()){
			getLevel().goToNextScene();
		}

		super.update(delta);
	}

}
