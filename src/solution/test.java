package solution;

import algo.Greedy;

public class test {

	public static void main(String[] args) {
		Tableau t = new Tableau();
		int nbPers = 10; 
		int nbTache = 10;
		int[][] tab = t.getTab(nbPers, nbTache);
		
		Solution initiale = new Solution(nbTache,nbPers,tab);
		Greedy g = new Greedy(initiale);
		
		
		
		g.trouverSolution();
		
		System.out.println(g.getSolutionEnCours());
		System.out.println(g.getSolutionEnCours().evaluation());
		System.out.println();
		while(!g.ameliorerSolution()){System.out.println(g.getSolutionEnCours());}

	}

}
