package algo;

import generic.AlgorithmeAbstract;
import generic.ProblemeAbstract;
import generic.SolutionAbstract;

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
	public Greedy(ProblemeAbstract probleme, SolutionAbstract initiale) {
		super(probleme, initiale);
	}

	/**
	 * permet d'améliorer la solution selon une approche gloutonne
	 */
	public boolean ameliorerSolution() {
		boolean res = false;
		//on construit le voisinage
		ArrayList<SolutionAbstract> voisinage = (ArrayList<SolutionAbstract>) this.solutionEnCours.retourneVoisinage();
		//on selectionne une valeur
		SolutionAbstract voisin = this.solutionEnCours;
		double min = this.problemeATraiter.evaluation(this.solutionEnCours);
		for(SolutionAbstract sol : voisinage){
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
