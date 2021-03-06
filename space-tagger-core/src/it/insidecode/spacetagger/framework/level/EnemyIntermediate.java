package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Classe astratta che definisce i nemici intermedi
 * serve per dare un parent comune ai nemici boss
 * e per definire computeMove()
 * @author Seria.1616892
 *
 */
public abstract class EnemyIntermediate extends GfxEnemy{

	public EnemyIntermediate(Framework framework, Vector2 position,
			float energy, int scoreValue, float damageValue, float speed,
			String idleAnimPath, String deadAnimPath) {
		super(framework, position, energy, scoreValue, damageValue, speed,
				idleAnimPath, deadAnimPath);
	}
	
	public EnemyIntermediate(Framework framework, Vector2 position,
			float energy, int scoreValue, float damageValue, float speed,
			String idleAnimPath, String deadAnimPath, SimpleCallback c) {
		super(framework, position, energy, scoreValue, damageValue, speed,
				idleAnimPath, deadAnimPath, c);
	}
	
	public void computeMove(){}

}
