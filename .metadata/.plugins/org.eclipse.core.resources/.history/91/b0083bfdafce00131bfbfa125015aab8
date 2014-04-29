package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;

import com.badlogic.gdx.math.Vector2;

public class BlasteroidCluster extends Blasteroid {

	private Framework framework;

	public BlasteroidCluster(final Framework framework, Vector2 position,
			int asteroidNum) {
		super(framework, position);
		this.framework = framework;
		int i = 0;
		while (i < asteroidNum) {
			makeAsteroid();
			i++;
		}
	}

	private void makeAsteroid() {
		BlasteroidPointless a = new BlasteroidPointless(framework,
				new Vector2((float) Math.random() * 480 - 240,
						(float) Math.random() * 100), this);
		addChildEntity(a);
		a.activate();
	}

}
