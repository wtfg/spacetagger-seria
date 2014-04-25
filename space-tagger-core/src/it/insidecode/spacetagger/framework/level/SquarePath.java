package it.insidecode.spacetagger.framework.level;


import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;

import com.badlogic.gdx.math.Vector2;

public class SquarePath extends Path {

	private Path[] pathsArray;
	private Path delegate;
	private int current = 0;

	public SquarePath(int curr) {
		super();
		current = curr;
		pathsArray = new Path[] { new LinePath(LineDirection.LEFT, 100),
				new LinePath(LineDirection.DOWN, 100),
				new LinePath(LineDirection.RIGHT, 100),
				new LinePath(LineDirection.UP, 100)};
		delegate = pathsArray[current];
	}

	private void resetPaths(){
		for	(Path p : pathsArray){
			p.reset();
		}
		
	}
	@Override
	public Vector2 getNextPositionIncrement(float speed) {
		if (delegate.isComplete()) {
			if(isComplete())
				resetPaths();
			current = (current + 1) % 4;
			delegate = pathsArray[current];
			
		}
		return delegate.getNextPositionIncrement(speed);
	}

	@Override
	public boolean isComplete() {
		return current == pathsArray.length-1 && delegate.isComplete();
	}

	@Override
	public float getX(float speed) {
		return 0;
	}

	@Override
	public float getY(float speed) {
		return 0;
	}

	@Override
	public void reset() {
		current = 0;
	}

}
