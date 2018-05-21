package algo;

import java.util.ArrayList;

import generic.AlgorithmeAbstract;
import solution.Solution;

/**
 * classe representant un algorithme de type greedy
 * 
 * @author vthomas
 *
 */
public class Greedy extends AlgorithmeAbstract {

	/**
	 * constructeur d'un algorithme greedy
	 * 
	 * @param probleme
	 *            le probleme a resoudre
	 * @param initiale
	 *            la solution initiale a modifier
	 */
	public Greedy( Solution initiale) {
		super( initiale);
	}

	/**
	 * permet d'améliorer la solution selon une approche gloutonne
	 */
	public boolean ameliorerSolution() {
		boolean res = false;
		//on construit le voisinage
		ArrayList<Solution> voisinage = (ArrayList<Solution>) this.solutionEnCours.retourneVoisinage();
		//on selectionne une valeur 
		Solution voisin = this.solutionEnCours;
		double min = this.valeur();
		for(Solution sol : voisinage){
			double valSolK = sol.evaluation(); 
			if(valSolK < min){
				voisin = sol;
				min = valSolK;
			}
		}
		//on developpe un noeud suivant
		if(min == this.solutionEnCours.evaluation()){
			res = true;
		}
		this.solutionEnCours = voisin;
		// on s'arrete si la solution ne s'ameliore plus
		return res;
	}
	
	/**
	 * permet de trouver une solutionselon une approche gloutonne
	 */
	public void trouverSolution(){
		ArrayList<Solution> voisins;
		Solution tmp;int val;
		while(!this.solutionEnCours.estComplete()){
			voisins = this.solutionEnCours.retourneVoisinage();
			tmp = voisins.get(0);
			val = tmp.evaluation();
			for(Solution s :voisins){
				int valS = s.evaluation();
				if(valS<val){
					tmp = s;
					val = valS;
				}
			}
			this.solutionEnCours = tmp;
		}
	}

}
