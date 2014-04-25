package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Level;




public class Level0 extends Level {

	public static final String LEVEL_NAME = "Level 0";
	
	public Level0(Framework framework) {
		super(framework, new Scene01(framework), new Scene02(framework), new Scene03(framework), new Scene04(framework), new Scene05(framework), new Scene06(framework), new Scene07(framework));
		
	}

	@Override
	public String getName() {
		return LEVEL_NAME;
	}
}
