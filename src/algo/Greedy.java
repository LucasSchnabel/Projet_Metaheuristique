package algo;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;
import solution.Solution;

import java.util.ArrayList;

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
	public Greedy(ProblemeAbstract probleme, Solution initiale) {
		super(probleme, initiale);
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
			double valSolK = this.problemeATraiter.evaluation(sol); 
			if(valSolK < min){
				voisin = sol;
				min = valSolK;
			}
		}
		//on developpe un noeud suivant
		if(min == this.problemeATraiter.evaluation(this.solutionEnCours)){
			res = true;
		}
		this.solutionEnCours = voisin;
		// on s'arrete si la solution ne s'ameliore plus
		return res;
	}

}
