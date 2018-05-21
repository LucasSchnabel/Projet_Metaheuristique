package generic;

import algo.Greedy;
import algo.RecuitSimule;

/**
 * algorithme abstrait
 * <p>
 * se base sur un probleme abstrait et des solutions abstraites à implementer
 * 
 * @author vthomas@loria.fr
 * 
 */

public abstract class AlgorithmeAbstract {

	/**
	 * solution en cours à modifier au fur et mesure de l'algorithme
	 */
	protected Solution solutionEnCours;

	/**
	 * construit un algorithme à partir d'une solution initiale
	 * 
	 * @param probleme
	 *            definition du probleme à traiter
	 * @param solutionInitiale
	 *            solution initiale
	 */
	public AlgorithmeAbstract(Solution solutionInitiale) {
		this.solutionEnCours = solutionInitiale;
	}

	/**
	 * méthode a redefinir
	 * 
	 * @return booleen pour arreter eventuellement la boucle
	 */
	public abstract boolean ameliorerSolution();

	/**
	 * factory simple permet recuperer un algorithme donné
	 * 
	 * @param probleme
	 *            le probleme à resoudre
	 * @param solutionInitiale
	 *            la solution initiale
	 * @param nom
	 *            le nom de l'algo
	 */
	public static AlgorithmeAbstract getAlgo(String nom, Solution solutionInitiale) {
		switch (nom) {
		case "greedy":
			return new Greedy(solutionInitiale);
		case "recuit":
			return new RecuitSimule(solutionInitiale, 1000);

		return (null);
	}

	/**
	 * permet de retourner la valeur de la solution courante
	 * 
	 * @return valeur de s selon probleme pb
	 */
	public double valeur() {
		return this.solutionEnCours.evaluation();
	}

	/**
	 * permet d'afficher le contenu de l'algo
	 * 
	 * @return par defaut la valeur
	 */
	public String log() {
		return "" + problemeATraiter.evaluation(getSolutionEnCours());
	}

	public Solution getSolutionEnCours() {
		return solutionEnCours;
	}

}
