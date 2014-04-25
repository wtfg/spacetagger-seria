package it.insidecode.spacetagger;

import it.insidecode.spacetagger.framework.core.Core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "space-tagger";
		cfg.useGL20 = true;
		cfg.width = 480;
		cfg.height = 640;
		new LwjglApplication(new SpaceTagger(Core.getLevel()), cfg);
	}
}
