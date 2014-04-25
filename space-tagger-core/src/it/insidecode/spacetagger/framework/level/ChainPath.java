package it.insidecode.spacetagger.framework.level;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.Path;

public class ChainPath extends Path {
	
	private float sign;
	private Enemy e1;
	private Enemy e2;
	
	public ChainPath(Enemy e1, Enemy e2){

		this.e1 = e1;
		this.e2 = e2;
		
		sign = new Random().nextInt(2000) - 1000;
		sign = sign != 0 ? sign/(Math.abs(sign)) : 1;
	}

	public Vector2 getNextPositionIncrement(float speed){
		
		if(!e1.isAlive() || e2.getPosition().y < 30)
			return new Vector2(sign*0.5f,-2f);
		Vector2 delta = e1.getPosition().sub(e2.getPosition());
		return delta.div(500/(delta.len()));	
		
	}
	@Override
	protected float getX(float arg0) {
		return 0;
	}

	@Override
	protected float getY(float arg0) {
		return 0;
	}

	@Override
	public boolean isComplete() {
		return false;
	}

}