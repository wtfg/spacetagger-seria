package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;

import com.badlogic.gdx.math.Vector2;

public class DownSlidePath extends Path {

	private Path[] pathsArray;
	private Path currentPath;
	private int current = 0;

	public DownSlidePath(int w, int h, LineDirection verse1) {
		LineDirection verse2 = verse1 == LineDirection.RIGHT ? LineDirection.LEFT : LineDirection.RIGHT;
		pathsArray = new Path[] { new LinePath(LineDirection.DOWN, h),
				new LinePath(verse1, w),
				new LinePath(verse2, w)};
		currentPath = pathsArray[current];
	}

	@Override
	public Vector2 getNextPositionIncrement(float speed) {
		if (currentPath.isComplete()) {
			if ((current) >= 2) {
				for (Path x : pathsArray)
					x.reset();
				current = 0;
			}
			currentPath = pathsArray[++current];
		}
		return currentPath.getNextPositionIncrement(speed);
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

	@Override
	public boolean isComplete() {
		return current == pathsArray.length && currentPath.isComplete();
	}

}
