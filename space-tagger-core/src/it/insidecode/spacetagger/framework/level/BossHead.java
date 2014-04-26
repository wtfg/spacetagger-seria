package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.graphics.HorizontalBar;
import it.insidecode.spacetagger.logic.Depth;


import com.badlogic.gdx.math.Vector2;

/**
 * Un nemico grosso e cattivo
 * 
 * @author Seria.1616892
 * 
 */
public class BossHead extends GfxEnemy {

	/**
	 * Costanti
	 */
	private static final float ENERGY_VALUE = 50;
	private static final int SCORE_VALUE = 30000;
	private static final float DAMAGE_VALUE = 3f;
	private static final float SPEED_VALUE = 0.5f;
	private static final String fileName = "bossHead";
	
	private int SHOOT_UPDATE_TIME = 1000;
	private Framework framework;
	private HorizontalBar b;
	
	// t e limit servono per aggiornare il tempo di sparo
	private int t;
	private int limit = SHOOT_UPDATE_TIME;

	/**
	 * 
	 * @param f
	 *            istanza del framework corrente
	 * @param position
	 *            un Vector2 che indica la posizione nella quale il nemico va
	 *            spawnato
	 */
	public BossHead(Framework f, Vector2 position) {
		super(f, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter("xplosion"));
		framework = f;
		setCenter(position);
		setShot(EnemyShot.class);
		setShotDecorator(BorgShotDecorator.class);
		b = new HorizontalBar(framework.getGameEngine(), new Vector2(50,-20), 70, 5, ENERGY_VALUE);
		addChildEntity(b);
		b.activate();
	}
	

	/**
	 * Comportamento classico, inclusi degli spari in un tempo random ogni 300
	 * frames random
	 */
	@Override
	public void update(float delta) {
		super.update(delta);		
		b.setValue(getEnergy());

		
		t++;
		if (t > limit) {
			limit = SHOOT_UPDATE_TIME;
			t = 0;
			if (isAlive()){
				spitEnemies();
			}
		}

	}
	

	
	private void spitEnemies(){
		
		EnemySnakeTail k = new EnemySnakeTail(framework, getPosition(), 1);
		k.setPath(new FollowShipPath(framework, k));
		k.setDepth(Depth.ENTITY1);
		k.activate(); 
		
		EnemySnakeTail i = new EnemySnakeTail(framework, getPosition().add(120,0), 1);
		i.setSpeed(3f);
		i.setPath(new FollowShipPath(framework, i));
		i.setDepth(Depth.ENTITY1);
		i.activate();
	}

	@Override
	public void destroy(){
		b.destroy();
		framework.getGameEngine().getScoreManager().increaseScore(SCORE_VALUE);
		super.destroy();
	}
}
