package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;

import com.badlogic.gdx.math.Vector2;

/**
 * Un EnemyClusterSquare, ovvero un quadrato di nemici 
 * a grappolo che gira attorno al nemico.
 * Creata allo scopo di estendere EnemyCluster
 * 
 * @author Seria.1616892
 *
 */
public class EnemyClusterSquare extends EnemyCluster {

	/**
	 * Inizializza il nemico a grappolo  alla
	 * posizione descritta da <i>position</i>, per attivarlo
	 * bisogna chiamare il metodo <b>activate()</b>
	 * 
	 * @param framework	istanza del framework corrente
	 * @param position	posizione di spawn del nemico
	 * @param range		distanza dei nemici
	 */
	public EnemyClusterSquare(Framework framework, Vector2 position, int range) {
		super(framework, position, getChildren(framework, range));
	}
	
	/**
	 * Metodo chiamato dal costruttore che restituisce
	 * al costruttore la lista gfxEnemy[] da impostare 
	 * 
	 * @param framework
	 * @return
	 */
	private static GfxEnemy[] getChildren(Framework framework, int range){
		
		GfxEnemy[] square = new GfxEnemy[4];
		for (int i=0; i<square.length; i++){
			
			// variabili per definire gli angoli 
			int a = i == 0 || i == 3 ? 1 : -1;
			int b = i < 2 ? 1 : -1;
			
			square[i] = new EnemySimple(framework, new Vector2(a*range, b*range));
			square[i].setPath(new SquarePath(i));
		}
		return square;
	}

}
