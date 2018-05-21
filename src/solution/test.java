package solution;

import algo.Greedy;
import algo.RecuitSimule;

public class test {

	public static void main(String[] args) {
		Tableau t = new Tableau();
		int nbPers = 10; 
		int nbTache = 10;
		int[][] tab = t.getTab(nbPers, nbTache);
		
		Solution initiale = new Solution(nbTache,nbPers,tab);
		Greedy g = new Greedy(initiale);
		
		RecuitSimule r = new RecuitSimule(initiale, 1000);
		
		g.trouverSolution();
		
		System.out.println(g.getSolutionEnCours());
		System.out.println(g.getSolutionEnCours().evaluation());
		System.out.println();
		while(!g.ameliorerSolution()){System.out.println(g.getSolutionEnCours());}
		System.out.println("Recuit");
		for (int i = 0; i < 100; i++) {
			r.ameliorerSolution();
		}
		System.out.println(r.getSolutionEnCours());

	}

}
