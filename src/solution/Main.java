package solution;

import algo.Greedy;
import algo.RecuitSimule;

public class Main {

	public static void main(String[] args) {
		
		testSimple();
		testMoinsSimple();
		testComplexe();
		
	}
	
	public static void afficherTab(int[][] tab){
		String ligne = "";
		for(int i = 0;i<tab.length;i++){
			for(int j = 0;j<tab[i].length;j++){
				ligne += tab[i][j]+",";
			}
			System.out.println(ligne);
			ligne = "";
		}
	}
	
	public static void testSimple(){
		System.out.println("D�but du test simple :");
		int nbIteration = 2500;
		int nbPers = 4; 
		int nbTache = 5;
		int[][] tab = Tableau.getTab(nbPers, nbTache);
		afficherTab(tab);
		Solution initiale = new Solution(nbTache,nbPers,tab);
		
		Greedy g = new Greedy(initiale);
		
		g.trouverSolution();
		System.out.println("Solution construit avec Greedy :");
		System.out.println(g.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+g.getSolutionEnCours().evaluation());
		
		while(!g.ameliorerSolution()){System.out.println(g.getSolutionEnCours());}
		System.out.println("Solution am�lior� avec Greedy :");
		System.out.println(g.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+g.getSolutionEnCours().evaluation());
		
		RecuitSimule r = new RecuitSimule(initiale, 1000);
		
		for (int i = 0; i < nbIteration; i++) {
			r.ameliorerSolution();
		}
		System.out.println("Solution am�lior� avec recuit simul� :");
		System.out.println(r.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+r.getSolutionEnCours().evaluation());
	}
	
	public static void testMoinsSimple(){
		System.out.println("D�but du test moins simple :");
		int nbPers = 6; 
		int nbTache = 10;
		int nbIteration = 2500;
		int[][] tab = Tableau.getTab(nbPers, nbTache);
		afficherTab(tab);
		Solution initiale = new Solution(nbTache,nbPers,tab);
		
		Greedy g = new Greedy(initiale);
		
		g.trouverSolution();
		System.out.println("Solution construit avec Greedy :");
		System.out.println(g.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+g.getSolutionEnCours().evaluation());
		
		while(!g.ameliorerSolution()){System.out.println(g.getSolutionEnCours());}
		System.out.println("Solution am�lior� avec Greedy :");
		System.out.println(g.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+g.getSolutionEnCours().evaluation());
		
		RecuitSimule r = new RecuitSimule(initiale, 1000);
		
		for (int i = 0; i < nbIteration; i++) {
			r.ameliorerSolution();
		}
		System.out.println("Solution am�lior� avec recuit simul� :");
		System.out.println(r.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+r.getSolutionEnCours().evaluation());
	}
	
	public static void testComplexe(){
		System.out.println("D�but du test complexe :");
		int nbPers = 10; 
		int nbTache = 20;
		int nbIteration = 2500;
		int[][] tab = Tableau.getTab(nbPers, nbTache);
		afficherTab(tab);
		Solution initiale = new Solution(nbTache,nbPers,tab);
		
		Greedy g = new Greedy(initiale);
		
		g.trouverSolution();
		System.out.println("Solution construit avec Greedy :");
		System.out.println(g.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+g.getSolutionEnCours().evaluation());
		
		while(!g.ameliorerSolution()){System.out.println(g.getSolutionEnCours());}
		System.out.println("Solution am�lior� avec Greedy :");
		System.out.println(g.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+g.getSolutionEnCours().evaluation());
		
		RecuitSimule r = new RecuitSimule(initiale, 1000);
		
		for (int i = 0; i < nbIteration; i++) {
			r.ameliorerSolution();
		}
		System.out.println("Solution am�lior� avec recuit simul� :");
		System.out.println(r.getSolutionEnCours());
		System.out.println("Evaluation de la solution :"+r.getSolutionEnCours().evaluation());
	}

}
