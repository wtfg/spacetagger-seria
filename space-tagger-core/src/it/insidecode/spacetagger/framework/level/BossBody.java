package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.graphics.HorizontalBar;
import it.insidecode.spacetagger.logic.Depth;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.math.Vector2;

/**
 * Il corpo del boss
 * @author Seria.1616892
 * 
 */
public class BossBody extends EnemyIntermediate  {

	/**
	 * Costanti
	 */
	private static final float ENERGY = 100;
	private static final int SCORE = 30000;
	private static final float DAMAGE = 3f;
	private static final float SPEED = 0.5f;
	private static final String fileName = "boss";
	private static final String explosionName = "xplosion";
	
	/**
	 * Costanti di altre classi
	 */
	
	private static final Vector2 shieldPowerUpPos = new Vector2(240,450);
	private static final Vector2 furyPowerUpPos = new Vector2(240,400);
	private static final Vector2 barPos = new Vector2(50,-20);
	private static final Vector2 deltaEnemy = new Vector2(120,0);
	private static final int barWidth = 140;
	private static final int barHeight = 5;
	
	/**
	 * Variabili funzionali
	 */
	private static int SHOOT_UPDATE_TIME = 50;
	private Framework framework;
	private static HorizontalBar bar;
	private static FuryPowerUp furyPowerUp;
	private static ShieldPowerUp shieldPowerUp;
	
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
	public BossBody(Framework f, Vector2 position) {
		super(f, position, ENERGY, SCORE, DAMAGE,
				SPEED, PropertiesManager.getParameter(fileName),
				PropertiesManager.getParameter(explosionName), new SimpleCallback(){
			public void onComplete(){
				shieldPowerUp.activate();
				furyPowerUp.activate();
			}
		});
		
		framework = f;
		
		setCenter(position);
		setShot(BossShot.class);
		setShotDecorator(BorgShotDecorator.class);
		
		shieldPowerUp = new ShieldPowerUp(framework, shieldPowerUpPos);
		furyPowerUp = new FuryPowerUp(framework, furyPowerUpPos);
		bar = new HorizontalBar(framework.getGameEngine(), barPos, barWidth, barHeight, ENERGY);
		
		addChildEntity(bar);
		bar.activate();
	}
	

	/**
	 * Comportamento classico, inclusi degli spari in un tempo random ogni 300
	 * frames random
	 */
	@Override
	public void update(float delta) {
		
		super.update(delta);		
		bar.setEnergy(getEnergy());
		
		// inizia a parlare
		if(getPath().isComplete()){
			t++;
			if (t > limit) {
				limit = SHOOT_UPDATE_TIME;
				t = 0;
				if (isAlive()){
					shoot();
					spitEnemies();
				}
			}
		}

	}
	

	/**
	 * Spara dei nemici
	 */
	private void spitEnemies(){
		
		EnemySnakeTail k = new EnemySnakeTail(framework, getPosition(), 1);
		k.setPath(new FollowShipPath(framework, k));
		k.setDepth(Depth.ENTITY1);
		k.activate(); 
		
		EnemySnakeTail i = new EnemySnakeTail(framework, getPosition().add(deltaEnemy), 1);
		i.setPath(new FollowShipPath(framework, i));
		i.setDepth(Depth.ENTITY1);
		i.activate();
	}

	/**
	 * Se muore aggiungi punteggio e distruggi la barra orizzontale
	 */
	@Override
	public void destroy(){
		bar.destroy();
		framework.getGameEngine().getScoreManager().increaseScore(SCORE);
		super.destroy();
	}
}
