package solution;

import algo.Greedy;

public class test {

	public static void main(String[] args) {
		Tableau t = new Tableau();
		int nbPers = 4; 
		int nbTache = 4;
		int[][] tab = t.getTab(nbPers, nbTache);
		
		Solution initiale = new Solution(nbTache,nbPers,tab);
		Greedy g = new Greedy(initiale);
		
		g.trouverSolution();
		
		System.out.println(g.getSolutionEnCours().evaluation());
		
		while(!g.ameliorerSolution()){System.out.println(g.getSolutionEnCours());}

	}

}
