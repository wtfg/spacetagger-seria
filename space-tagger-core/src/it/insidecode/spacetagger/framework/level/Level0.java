package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Level;
import it.insidecode.spacetagger.graphics.ParallaxBackground;




public class Level0 extends Level {

	public static final String LEVEL_NAME = "Enter The Borg";
	
	public Level0(Framework framework) {
		super(framework, new Scene12(framework), new Scene01(framework), new Scene02(framework), new Scene03(framework), new Scene04(framework), new Scene05(framework), new Scene06(framework), new Scene07(framework), new Scene08(framework), new Scene09(framework), new Scene10(framework), new Scene11(framework), new Scene12(framework));
		ParallaxBackground p = new ParallaxBackground();
		p.setLevel0(PropertiesManager.getParameter("bg"), true);
		p.setLevel1(PropertiesManager.getParameter("stars"), true);
		framework.getGameEngine().setBackground(p);
	}

	@Override
	public String getName() {
		return LEVEL_NAME;
	}
}
